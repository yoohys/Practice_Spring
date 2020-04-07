package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;

import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyArticleHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";
	
	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modifyService = new ModifyArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {// 요청방식이 get이면 processForm실행
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {// 요청방식이 POST이면 processSubmit실행
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException{// 폼을 보여주는 뷰 경로 리턴
		try {
			String noVal=req.getParameter("no");
			int no = Integer.parseInt(noVal);
			
			ArticleData articleData = readService.getArticle(no, false); //폼에 보여줄 게시글 구하기
			User authUser= (User) req.getSession().getAttribute("authUser");//사용자정보구하기
			
			if(!canModify(authUser, articleData)) {//게시글작성자와 로그인사용자 비교 
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			//폼에 데이터 보여줄 떄 사용할 객체 생성 
			ModifyRequest modReq = new ModifyRequest(authUser.getId(), no, 
					articleData.getArticle().getTitle(), articleData.getContent());
			
			req.setAttribute("modReq", modReq);
			return FORM_VIEW;
			
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {// 폼 전송 처리
		User authUser=(User) req.getSession().getAttribute("authUser");//사용자 정보 구하기 
		String noVal=req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		//ModifyRequest 객체 생성 
		ModifyRequest modReq = new ModifyRequest(authUser.getId(), no, 
				req.getParameter("title"), req.getParameter("content"));
		req.setAttribute("modReq", modReq);
	
		//에러 정보를 담을 맵 객체 생성
		Map<String, Boolean> errors=new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			//게시글 수정기능 실행.
			modifyService.modify(modReq);
			return "/WEB-INF/view/modifySuccess.jsp";
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
	}
	
}

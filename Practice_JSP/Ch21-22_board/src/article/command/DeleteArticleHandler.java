package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.DeleteRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;

import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/deleteForm.jsp";
	
	private ReadArticleService readService = new ReadArticleService();
	private DeleteArticleService deleteService = new DeleteArticleService();
	
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
			
			if(!canDelete(authUser, articleData)) {//게시글작성자와 로그인사용자 비교 
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			//폼에 데이터 보여줄 떄 사용할 객체 생성 
			//DeleteRequest delReq = new DeleteRequest(authUser.getId(), no, 
			//		articleData.getArticle().getTitle(), articleData.getContent());
			DeleteRequest delReq = new DeleteRequest(authUser.getId(),no,articleData.getArticle().getTitle());
			req.setAttribute("delReq", delReq);
			return FORM_VIEW;
			
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private boolean canDelete(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {// 폼 전송 처리
		User authUser=(User) req.getSession().getAttribute("authUser");//사용자 정보 구하기 
		String noVal=req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		//deleteRequest 객체 생성 
		DeleteRequest delReq = new DeleteRequest(authUser.getId(),no,req.getParameter("title"));
		req.setAttribute("delReq", delReq);
	
		//에러 정보를 담을 맵 객체 생성
		Map<String, Boolean> errors=new HashMap<>();
		req.setAttribute("errors", errors);
		delReq.validate(errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			//게시글 삭제기능 실행.
			deleteService.delete(delReq);
			return "/WEB-INF/view/deleteSuccess.jsp";
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
	}
	
}

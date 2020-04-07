package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Writer;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {//웹요청처리
	private static final String FORM_VIEW="/WEB-INF/view/newArticleForm.jsp";
	private WriteArticleService writeService = new WriteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {// 요청방식이 get이면 processForm실행
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {// 요청방식이 POST이면 processSubmit실행
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {// 폼을 보여주는 뷰 경로 리턴
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {// 폼 전송 처리
		Map<String, Boolean> errors = new HashMap<>();// 에러정보를 담을 맵 객체를 생성하고 "errors"속성에 저장
		req.setAttribute("errors", errors);// JSP코드에서 발생한 에러에 따라 알맞은 에러메시지를 보여주기 위함
		
		//세션에서 로그인한 사용자 정보 구하기 
		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq=createWriteRequest(user, req);
		writeReq.validate(errors);//객체유효검사
		if (!errors.isEmpty()) {// errors 맵 객체에 데이터가 존재하면 폼 뷰 경로를 리턴
			return FORM_VIEW;
		}
		//WriteArticleService를 이용해서 게시글을 등록하고 등록된 게시글의 ID를 return
		int newArticleNo=writeService.write(writeReq); 
		
		//새 글의 ID를 request의 newArticledId 속성에 저장. 처리 결과를 보여줄 JSP는 이 속성값을 사용해서 링크 생성 
		req.setAttribute("newArticleNo", newArticleNo);//새 글의 ID를 request의 newArticledId 속성에 저장. 처리 결과를 보여줄 JSP는 이 속성값을 사용해서 링크 생성 
		
		return "/WEB-INF/view/newArticleSuccess.jsp";//로그인성공 
	}
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(new Writer(user.getId(), user.getName()), 
									req.getParameter("title"), 
									req.getParameter("content"));
	}
}

package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.DuplicateIdException;
import member.service.InvalidPasswordException;
import member.service.JoinRequest;
import member.service.JoinService;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/changePwdForm.jsp";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();

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
		User user = (User) req.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();// 에러정보를 담을 맵 객체를 생성하고 "errors"속성에 저장
		req.setAttribute("errors", errors);// JSP코드에서 발생한 에러에 따라 알맞은 에러메시지를 보여주기 위함

		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");

		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {// errors 맵 객체에 데이터가 존재하면 폼 뷰 경로를 리턴
			return FORM_VIEW;
		}

		
		try {
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd); //암호변경기능실행
			return "/WEB-INF/view/changePwdSuccess.jsp";//암호변경성공 후 changePwdSuccess.jsp를 뷰로 리턴
		} catch (InvalidPasswordException e) { 
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}

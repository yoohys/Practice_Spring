package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "WEB-INF/view/loginForm.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//폼에서 전송한 id파라미터와 password파라미터 값 구하기
		String id = trim(req.getParameter("id")); 
		String password = trim(req.getParameter("password"));
		
		//에러 정보를 담을 맵 객체 생성. errors속성에 저장.
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);

		//id나 password값이 없을경우 에러를 추가
		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		if(!errors.isEmpty()) //에러 존재시 폼 뷰 리턴
			return FORM_VIEW;
		
		try {
			User user = loginService.login(id, password); //loginService.login()을 이용해서 인증을 수행. 로그인 성공시 User객체 리턴
			req.getSession().setAttribute("authUser", user); //User 객체를 세션의 authUser 속성에 저장
			res.sendRedirect(req.getContextPath()+"/index.jsp");// /index.jsp로 리다이렉트 
			return null;
		}catch(LoginFailException e) { //로그인에 실패시 LoginFailException발생하면 해당 에러 추가하고 폼 뷰 리턴.
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
	

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}

package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

//사용자의 요청을 받고 사용자가 폼을 요청한 경우 폼을 보여주기 폼 데이터를 전송한 경우 JoinService를 이용해서 회원가입 처리
public class JoinHandler implements CommandHandler{//CommandHandler 인터페이스를 구현함
	
	private static final String FORM_VIEW="/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	
	@Override 
	public String process(HttpServletRequest req, HttpServletResponse res){
		if(req.getMethod().equalsIgnoreCase("GET")) {//요청방식이 get이면 processForm실행
			return processForm(req,res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {//요청방식이 POST이면 processSubmit실행
			return processSubmit(req,res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {//폼을 보여주는 뷰 경로 리턴
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {//폼 전송 처리
		JoinRequest joinReq=new JoinRequest();//객체 생성 
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		Map<String, Boolean> errors=new HashMap<>();//에러정보를 담을 맵 객체를 생성하고 "errors"속성에 저장
		req.setAttribute("errors", errors);//JSP코드에서 발생한 에러에 따라 알맞은 에러메시지를 보여주기 위함 
		
		joinReq.validate(errors);//JoinRequest객체의 값이 올바른지 검사. 값이 올바르지 않을 경우 errors맵 객체에 키를 추가
		
		//errors 맵 객체에 데이터가 존재하면 폼 뷰 경로를 리턴
		//(errors에 데이터가 존재한다면 joinReq 객체의 데이터가 올바르지 않아 에러와 관련된 키를 추가했다는 것을 의미함.) 
		//joinReq는 폼에 입력한 데이터를 저장하고 있으므로 폼에 입력한 데이터가 올바르지 않으면 다시 폼을 보여줌.
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			joinService.join(joinReq);
			return "/WEB-INF/view/joinSuccess.jsp";
		}catch(DuplicateIdException e) { //동일한 아이디로 가입한 회원이 존재할시
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}

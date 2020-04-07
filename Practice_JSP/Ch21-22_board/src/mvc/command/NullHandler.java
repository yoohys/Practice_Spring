package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler{//404에러를 응답으로 전송하는 핸들러 클래스

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
}

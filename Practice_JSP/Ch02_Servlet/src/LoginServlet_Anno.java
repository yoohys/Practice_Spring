

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//URL Mapping: Annotation 방식
//             현재개발방식
@WebServlet("/login_anno")
public class LoginServlet_Anno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet_Anno() {
        super();
        
    }

//login?id=abcd&passwd=1234
//HttpServletRequest :클라이언트 요청 저장
//HttpServletResponse: 실행된 결과값 저장(클라이언트에 보낼 용도)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		String id = request.getParameter("id");//abcd
		String passwd = request.getParameter("passwd");//abcd
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("아이디="+id+"<br>");
		out.println("비밀번호="+passwd+"<br>");
		
;	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

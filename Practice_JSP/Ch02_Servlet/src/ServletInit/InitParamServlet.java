package ServletInit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"디렉토리 경로: c:\\test"
		//"아이디 값:  admin"
		//getInitParameter(name) 사용
		String dirPath = getInitParameter("dirPath");
		String userid = getInitParameter("userid");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.print("<html><body>");
		out.print("디렉토리 경로::"+dirPath+"<br>");
		out.print("아이디값::"+userid+"<br>");
		out.print("</body></html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

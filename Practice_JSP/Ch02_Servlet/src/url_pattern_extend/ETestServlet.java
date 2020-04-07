package url_pattern_extend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/Ch02_Servlet/xxx.do 		:E
//먼저 적용되는게 있으면 적용 안된다 
//http://localhost:8080/Ch02_Servlet/test/a.nhn 	:G
//http://localhost:8080/Ch02_Servlet/asdf/ss.go 	:F

@WebServlet("*.do")
public class ETestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ETestServlet");
	}

}

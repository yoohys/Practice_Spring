package url_pattern_extend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8080/Ch02_Servlet/xxx.do      :E
//        다른 서블릿에서 (/*)하면 그 서블릿이 열린다.
//http://localhost:8080/Ch02_Servlet/test/a.nhn  :G
//http://localhost:8080/Ch02_Servlet/xyz/a.do    :E
//http://localhost:8080/Ch02_Servlet/xyz.nhn     :G
//http://localhost:8080/Ch02_Servlet/kk.go       :F
//http://localhost:8080/Ch02_Servlet/my/ss.go	 :F

@WebServlet("*.do")
public class ETestServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ETestServlet");
	}

}

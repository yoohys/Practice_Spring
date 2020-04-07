package url_pattern_dirctory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:8080/Ch02_Servlet/ATest       :A
//http://localhost:8080/Ch02_Servlet/test        :D
//http://localhost:8080/Ch02_Servlet/test/BTest  :B
//http://localhost:8080/Ch02_Servlet/            :C
//http://localhost:8080/Ch02_Servlet/xxx         :C
//http://localhost:8080/Ch02_Servlet/KKK         :C
@WebServlet("/ATest")
public class ATestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ATestServlet");
	}

}

package url_pattern_directory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Atest")
//http://localhost:8080/Ch02_Servlet.Servlet/Atest			:A
//http://localhost:8080/Ch02_Servlet.Servlet/test			:D
//http://localhost:8080/Ch02_Servlet.Servlet/test/Btest		:B
//http://localhost:8080/Ch02_Servlet.Servlet/				:C
//http://localhost:8080/Ch02_Servlet.Servlet/kkk			:C
//http://localhost:8080/Ch02_Servlet.Servlet/asdf			:C
//http://localhost:8080/Ch02_Servlet.Servlet/fuc			:C

public class ATestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ATestServlet");
	}

}

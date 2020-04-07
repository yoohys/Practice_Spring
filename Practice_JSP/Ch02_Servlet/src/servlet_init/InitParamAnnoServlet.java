package servlet_init;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="InitParamAnnoServelt", urlPatterns= {
		"/InitParamAnno"}, initParams= {@WebInitParam(name="dirPath",value="c:\\test"),
										@WebInitParam(name="username",value = "system")})

public class InitParamAnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(getInitParameter("dirPath"));
		System.out.println(getInitParameter("username"));
		
	}

	

}

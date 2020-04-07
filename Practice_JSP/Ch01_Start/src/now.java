

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class now
 */
@WebServlet("/now")
public class now extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html"); 
		resp.setCharacterEncoding("UTF-8");

		
		Date d = new Date();
		PrintWriter out = resp.getWriter();
		out.write("<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>CurrentTime(Servlet)</title>\r\n" + "</head>");
		out.write("<body><h3> 현재시각 : ");
		out.print(d);
		out.write("</h3></body></html>");
		out.close();
		
	
	}

}

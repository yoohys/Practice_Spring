package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;




@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session =request.getSession();
		
		String food = request.getParameter("food");
		if(food!=null)
			session.setAttribute("food", food);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Insert title here</title></head><body><h4>좋아하는 동물</h4><form action='ResultServlet'><input type=\"text\" name=\"animal\">\r\n" + 
				"<input type=\"submit\" value=\"확인\">\r\n" + 
				"</form>\r\n" + 
				"</body></html>");

	}


}

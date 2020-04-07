package application_attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextServlet_get")
public class ContextServlet_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String a = (String) getServletContext().getAttribute("name");
		int b = (int) getServletContext().getAttribute("age");
		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.println("이름 : " + a);
		out.println("나이 : " + b);
		out.print("</body></html>");
	}

}

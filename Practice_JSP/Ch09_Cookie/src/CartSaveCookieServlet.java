

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartSaveCookie")
public class CartSaveCookieServlet extends HttpServlet {
	static int i=1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Cookie c = new Cookie("basket"+i, request.getParameter("car"));
		i++;
		c.setMaxAge(60*60);
		response.addCookie(c);
		out.println("<!DOCTYPE html><html><head></head><body> Product 추가" +
"<a href =\'CartBasketCookie\'>  장바구니 보기2</a href></body></html>");

	}
}


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartDeleteCookie")
public class CartDeleteCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		Cookie[] c = request.getCookies();
		if (c != null && c.length > 0) {
			for (int i = 1; i <= c.length+1; i++) {

				Cookie cookie = new Cookie("basket" + i, "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);

			}
		}

		CartSaveCookieServlet s = new CartSaveCookieServlet();
		s.i=1;
		out.println("<!DOCTYPE html><html><head></head><body>");
		out.println("<a href ='ex2/cookie.html'>상품 선택 페이지</a href>");
		out.print("</body></html>");
	}
}

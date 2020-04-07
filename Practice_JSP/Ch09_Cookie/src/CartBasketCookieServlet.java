

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartBasketCookie")
public class CartBasketCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
	
		out.println("<!DOCTYPE html><html><head></head><body>");  
				
		out.println("장바구니 리스트<br>");
		Cookie[] c = request.getCookies();
		if(c!=null&c.length>0) {
			for(int i =0; i<c.length; i++) {
				out.println(c[i].getName()+" : ");
				out.println(c[i].getValue()+"<br>");
			}
		}
		out.println("<a href ='ex2/cookie.html'>상품 선택 페이지</a href><br>");
		out.println("<a href ='CartDeleteCookie'>장바구니 비우기</a href><br>");
		out.print("</body></html>");
	
	}
}

//Servlet : 서버에서 수행되는 WEB 자바;
//MVC Model1 : Client의 요청을 직접 Servlet이 받을 경우;
//				get방식인 경우 : doGet( )
// 				post방식인 경우 : doPost( )

import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class currentTime_Servlet
 */
@WebServlet("/currentTime_Servlet")
public class currentTime_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Client가 method="get" 방식으로 요청한 경우 받는 메소드;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		resp.setContentType("text/html"); // Client 브라우저에 전달할 내용 작성
		resp.setCharacterEncoding("UTF-8"); //

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		PrintWriter out = resp.getWriter();
		out.write("<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>CurrentTime(Servlet)</title>\r\n" + "</head>");
		out.write("<body><h3>Servlet(Get):: 현재시각은 ");
		out.println(hour);
		out.write("시 ");
		out.println(minute);
		out.write("분 ");
		out.write(Integer.toString(second));
		out.write("초 입니다.");

		out.write("</h3></body></html>");
		out.close();

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		resp.setContentType("text/html"); // Client 브라우저에 전달할 내용 작성
		resp.setCharacterEncoding("UTF-8"); //

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		PrintWriter out = resp.getWriter();
		out.write("<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>CurrentTime(Servlet)</title>\r\n" + "</head>");
		out.write("<body><h3>Servlet(POST):: 현재시각은 ");
		out.println(hour);
		out.write("시 ");
		out.println(minute);
		out.write("분 ");
		out.write(Integer.toString(second));
		out.write("초 입니다.");

		out.write("</h3></body></html>");
		out.close();

	}

}


//Servlet : �������� ����Ǵ� WEB �ڹ�;
//MVC Model1 : Client�� ��û�� ���� Servlet�� ���� ���;
//				get����� ��� : doGet( )
// 				post����� ��� : doPost( )

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
	
	// Client�� method="get" ������� ��û�� ��� �޴� �޼ҵ�;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		resp.setContentType("text/html"); // Client �������� ������ ���� �ۼ�
		resp.setCharacterEncoding("UTF-8"); //

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		PrintWriter out = resp.getWriter();
		out.write("<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>CurrentTime(Servlet)</title>\r\n" + "</head>");
		out.write("<body><h3>Servlet(Get):: ����ð��� ");
		out.println(hour);
		out.write("�� ");
		out.println(minute);
		out.write("�� ");
		out.write(Integer.toString(second));
		out.write("�� �Դϴ�.");

		out.write("</h3></body></html>");
		out.close();

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		resp.setContentType("text/html"); // Client �������� ������ ���� �ۼ�
		resp.setCharacterEncoding("UTF-8"); //

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		PrintWriter out = resp.getWriter();
		out.write("<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>CurrentTime(Servlet)</title>\r\n" + "</head>");
		out.write("<body><h3>Servlet(POST):: ����ð��� ");
		out.println(hour);
		out.write("�� ");
		out.println(minute);
		out.write("�� ");
		out.write(Integer.toString(second));
		out.write("�� �Դϴ�.");

		out.write("</h3></body></html>");
		out.close();

	}

}

package jsp2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/PersonalInfoSevlet")
public class PersonalInfoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	PersonalInfo p = new PersonalInfo();
	p.setName("홍길동");
	p.setGender('남');
	p.setAge(24);
	
	request.setAttribute("pinfo", p);
	
	//forward
	RequestDispatcher d = request.getRequestDispatcher("/ex5/customerInfoViewer.jsp");
	d.forward(request, response);
	}

}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//URL Mapping 방식: web.xml
//                 기존의 개발방식
//@WebServlet("/LoginServlet_webxml")
public class LoginServlet_webxml extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //요청
				String id = request.getParameter("id");//abcd
				String passwd = request.getParameter("passwd");//abcd
				
				//응답
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("아이디="+id+"<br>");
				out.println("비밀번호="+passwd+"<br>");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

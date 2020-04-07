
<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.io.*"%>
<%
	String agree = request.getParameter("agree");
	String result = null;
	if (agree.equals("yes")) {
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
		
		result = "success";

		PrintWriter writer = null;
		try {
			
			request.getSession().getServletContext().getRealPath("/");
			String filePath = application.getRealPath("/" + id + ".txt");
			writer = new PrintWriter(filePath);
			writer.println("아이디 : "+id);
			writer.println("비밀번호 : "+pw);
			writer.println("이름 : "+name);
			
			
			
		} catch (Exception ioe) {
			result = "fail";
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	} else {
		result = "fail";
%>
<script>
	alert("동의하지 않으면 가입할수 없습니다.");
	location.href = "agreement.jsp";
</script>
<%
	}
	session.invalidate();
	response.sendRedirect("result.jsp?result=" + result);
%>

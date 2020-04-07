<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("UTF-8");
	PrintWriter pw = response.getWriter();
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	time.setTime(session.getCreationTime());
	

	if (request.getParameter("id").equals("asdf") && request.getParameter("pw").equals("asdf")) {
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));

	} else {
		pw.println("<script>alert('아이디나 비밀번호가 정확하지 않습니다.');");
		pw.println("location.href = 'left.jsp';");
		pw.println("</script>");
	}
%>
</head>
<body>
	<form action="logOut.jsp">
		<%=session.getAttribute("id")%>님 로그인 중<br> <input type="submit"
			value="로그아웃"><br>
		<hr>
		접속시간 :
		<%=formatter.format(time)%><br> 
		<%time.setTime(session.getLastAccessedTime()); %>
		마지막 접근시간 :
		<%=formatter.format(time)%>
	</form>
</body>
</html>
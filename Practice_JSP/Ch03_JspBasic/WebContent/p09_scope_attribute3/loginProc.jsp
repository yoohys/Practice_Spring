<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int i = (int) application.getAttribute("click");
	application.setAttribute("click", i + 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getParameter("id").equals("asdf") && request.getParameter("pw").equals("asdf")) {
			pageContext.forward("loginSuccess.jsp");
		} else {
			pageContext.forward("loginFail.jsp");
		}
	%>

</body>
</html>
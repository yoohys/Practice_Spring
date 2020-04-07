<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="nonNumberError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getParameter("a").equals("") || request.getParameter("b").equals("")) {
			throw new Exception();
		}
	%>
	<%
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		;
	%>
	<%=a%>+
	<%=b%>=
	<%=a + b%>입니다.
</body>
</html>
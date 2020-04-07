<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("memberid");
	if (id != null && id.equals("admin")) {
		response.sendRedirect("index.jsp?memberid=admin");
	} else {
%>


<%
	}
%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>잘못된 ID입니다.
</body>
</html>
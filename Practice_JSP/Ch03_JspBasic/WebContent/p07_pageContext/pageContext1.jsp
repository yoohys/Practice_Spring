<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext1</title>
</head>
<body>
	<%
		pageContext.forward("pageContext2.jsp");
	%>
</body>
</html>
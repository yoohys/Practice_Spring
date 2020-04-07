<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext2</title>
</head>
<body>
	<%
		pageContext.include("pageContext3.jsp");
	%>
	<h3>pageContext의 forward 메소드로 포워딩된 페이지입니다</h3>
</body>
</html>
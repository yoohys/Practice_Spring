<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession(false); //
if(session.getAttribute("id")!=null){
	%>
	<h3>right.jsp</h3>
	<img alt="image" src="1.jpg">
	<br>
	<h3>접속중입니다.</h3>
<% }else{%>
<h3>right.jsp</h3>
<h2>로그인 되어있지 않은 상태입니다.</h2>
<%} %>

</body>
</html>
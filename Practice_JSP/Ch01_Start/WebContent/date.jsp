<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
	Date d = new Date();
	SimpleDateFormat s = new SimpleDateFormat("yyyy년 MM월 DD일");
	String str = s.format(d);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Apach Tomcat::<br>
Apache:: Web Server<br>
Tomcat Server: WAS(Web Application Server);

	현재날짜는
	<%=str%>입니다.
</body>
</html>
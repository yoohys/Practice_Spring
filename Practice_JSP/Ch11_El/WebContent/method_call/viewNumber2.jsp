<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.FormatUtil"%>
<%
	request.setAttribute("price", 12345);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	가격은
	<b>${FormatUtil.number(price,'#,##0') }</b>원 입니다.
</body>
</html>
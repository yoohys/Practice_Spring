<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	autoFlush = true 버퍼차면 바로 출력
	<br>
	<%
		for (int i = 0; i < 1000; i++) {
	%>
	1234
	<%
		}
	%>
</body>
</html>
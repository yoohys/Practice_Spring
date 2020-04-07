<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("id", "hong@abc.com");
		request.setAttribute("name", "홍길동");
	%>
	forwardFrom.jsp페이지 입니다.
	<br>
	화면에 절대로 표시 안됩니다.<hr>
	<jsp:forward page="forwardTo.jsp"></jsp:forward>
</body>
</html>
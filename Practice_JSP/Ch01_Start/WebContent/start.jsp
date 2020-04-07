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
		String bookTitle = "Jsp 프로그래밍";
		String author = "홍길동";
	%>
	<b><%=bookTitle%></b>를 쓰는 사람은
	<%=author%>입니다.
</body>
</html>
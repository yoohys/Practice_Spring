<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: pink;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자로 로그인성공</h3>
	전고객
	<br>(
	<%=request.getParameter("id")%>)님 환영합니다.
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int i = (int) application.getAttribute("click");
	application.setAttribute("click", i + 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<form action="loginProc.jsp">

		아이디 : <input type="text" name="id"> <br> 비밀번호 : <input
			type="password" name="pw"> <input type="submit" value="로그인">

	</form>
</body>

</html>
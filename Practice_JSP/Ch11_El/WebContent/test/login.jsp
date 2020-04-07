<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<jsp:useBean id="s" class="test.LoginBean" scope="request">
	<jsp:setProperty name="s" property="userid" ></jsp:setProperty>
	<jsp:setProperty name="s" property="passwd" ></jsp:setProperty></jsp:useBean>
	<%
	s.setUserid(request.getParameter("id"));
	s.setPasswd(request.getParameter("pw"));
	
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 실습</title>
</head>
<body>
	<h2>ID & PW 를 EL방식으로 입력 받기</h2>
	사용자 아이디: ${s.userid }
	<br> 사용자 비밀번호: ${s.passwd}
	<br>
</body>
</html>

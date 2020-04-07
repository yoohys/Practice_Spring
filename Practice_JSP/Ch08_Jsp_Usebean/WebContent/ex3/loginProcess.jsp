<%@page import="jsp2.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="test" class="jsp2.Login">
	<jsp:setProperty name="test" property="id"></jsp:setProperty>
		<jsp:setProperty name="test" property="pw"></jsp:setProperty></jsp:useBean>
		<% 
		Login lg = new Login();
		lg.setId("hong");
		lg.setPw("1234");
		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>로그인 정보</h4>
	아이디::
	<jsp:getProperty property="id" name="test" /><br>
	비밀번호::
	<jsp:getProperty property="pw" name="test" /><br>
	비밀번호(EL)::${test.pw }<br>F
	비밀번호(JAVA)::<%=test.getPw() %>
</body>
</html>
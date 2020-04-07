<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("id", request.getParameter("id"));
	request.setAttribute("pw", request.getParameter("pw"));
	int i= (int) application.getAttribute("click");
	application.setAttribute("click", i+1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h3>로그인에 성공 했습니다.</h3>
	로그인에 성공한 ID:
	<%=request.getAttribute("id")%>
</body>
</html>
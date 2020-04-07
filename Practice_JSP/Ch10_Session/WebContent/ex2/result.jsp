<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String checkName=null;
checkName = (String) session.getAttribute("uName");
if(checkName ==null){
	response.sendRedirect("loginForm.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=checkName %>님 안녕하세요!<br>
<a href="http://www.google.com">Google</a>
</body>
</html>
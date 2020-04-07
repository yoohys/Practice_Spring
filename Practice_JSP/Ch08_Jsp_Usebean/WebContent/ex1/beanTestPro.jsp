<%@page import="jsp1.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% --%>
<!-- // LoginBean lb = new LoginBean(); -->
<%-- %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="testBean" class="jsp1.LoginBean">
<jsp:setProperty name="testBean" property="id"></jsp:setProperty>
</jsp:useBean><br>
입력된 ID : <jsp:getProperty property="id" name="testBean"/>
</body>
</html>
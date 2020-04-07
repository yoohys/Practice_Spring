<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session = request.getSession();
String id = request.getParameter("id");
request.getSession().setAttribute("id", id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션ID::<%=session.getId() %><br>
<a href="test2.jsp">이동</a>
</body>
</html>
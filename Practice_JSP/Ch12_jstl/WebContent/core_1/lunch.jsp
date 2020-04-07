<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String arr[] ={"불고기","오무라이스","냉면"};
	request.setAttribute("MENU", arr);
%>
<jsp:forward page="lunchMenu.jsp"></jsp:forward>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
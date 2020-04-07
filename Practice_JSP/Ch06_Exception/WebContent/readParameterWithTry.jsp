<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% try{ %>
name parameter ::<%=request.getParameter("name").toUpperCase() %>
<%}catch(Exception e){ %>
	파라미터의 값이 올바르지 않습니다.
<%} %>

</body>
</html>
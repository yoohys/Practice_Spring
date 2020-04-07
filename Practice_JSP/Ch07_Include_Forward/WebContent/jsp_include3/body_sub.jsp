<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	body sub에서 name 파라미터값:<%=request.getParameter("name") %><br> name
	Parameter값 목록:: 2가지
	<hr>
	<ul>
		<% String [] names = request.getParameterValues("name");
		for(String str : names){%>
		<li><%=str %></li>
		<%}
		%>
	</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: separate;
}
</style>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>

	<h1>학생정보</h1>
	<table>
		<tr>
			<th>학번</th>
			<td>
				<%out.println(request.getParameter("snum")); %>
			</td>
		<tr>
			<th>이름</th>
			<td>
				<%out.println(request.getParameter("sname")); %>
			</td>
		<tr>
			<th>학년</th>
			<td>
				<%out.println(request.getParameter("stun")); %>
			</td>
		<tr>
			<th>선택과목</th>
			<td>
				<%out.println(request.getParameter("sub")); %>
			</td>
	</table>
	<hr>
	getPathInfo()::<%=request.getPathInfo() %><br>
	getRequestURI()::<%=request.getRequestURI() %><br>
	getServletPath()::<%=request.getServletPath() %><br>
	getServerName()::<%=request.getServerName() %><br>
</body>
</html>
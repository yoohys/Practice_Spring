<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	include 전 name파라미터 값 :
	<%=request.getParameter("name")%>
	<hr>
	<jsp:include page="body_sub.jsp" flush="false">
		<jsp:param value="홍길동" name="name" /></jsp:include>
		<hr>
		include 후 name Parameter 값: <%=request.getParameter("name") %>
</body>
</html>
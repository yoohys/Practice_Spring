<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	application.setAttribute("click", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>페이지영역에 저장된 데이타</h3>
	<br>
	<%
		pageContext.setAttribute("na", "na");
	%>
	<%=pageContext.getAttribute("na")%>

</body>
</html>
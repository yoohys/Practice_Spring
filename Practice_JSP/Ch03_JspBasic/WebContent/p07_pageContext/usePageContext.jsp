<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpServletRequest r = (HttpServletRequest) pageContext.getRequest();
	%>
	request 기본객체와 pageContext.getRequest() 동일여부 :
	<%=request = r%><br>
	<% pageContext.getOut().println("pageContext.getOut()1출력"); %>
	<% out.println("pageContext.getOut()2출력"); %>
</body>
</html>
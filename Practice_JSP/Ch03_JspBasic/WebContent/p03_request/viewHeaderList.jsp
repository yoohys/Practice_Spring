<%@page import="java.util.Enumeration"%>
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
		Enumeration<String> em = request.getHeaderNames();
		while (em.hasMoreElements()) {
			String headerName = em.nextElement();
			String headerValue = request.getHeader(headerName);
	%><%=headerName%>
	::
	<%=headerValue%><br>
	<%
		}
	%>
</body>
</html>
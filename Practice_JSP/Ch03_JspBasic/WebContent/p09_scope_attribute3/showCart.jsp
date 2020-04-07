<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 내용</title>
</head>
<body>
	장바구니 :
	<hr>
	<%
		Enumeration<String> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
	%>
	<%=session.getAttribute(en.nextElement())%>
	<%
		}
		int i = (int) application.getAttribute("click");
		application.setAttribute("click", i + 1);
	%>

</body>
</html>
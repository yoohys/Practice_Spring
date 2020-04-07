<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page buffer="1kb" %>
<%@ page errorPage="/error/viewErrorMessage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int i = 0; i < 300; i++) {
			out.println(i);
		}
	%>
	<%=1 / 0%>
</body>
</html>
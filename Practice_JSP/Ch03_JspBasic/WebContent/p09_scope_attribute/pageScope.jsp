<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "hong");
	request.setAttribute("id", "abc");
	session.setAttribute("name", "attribute");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	pageScope::
	<%=pageContext.getAttribute("name")%>
	<br> pageScope(EL)::${pageScope.name}
	<br>requestScope::
	<%=request.getAttribute("id")%>
	<br> requestScope(EL)::${requestScope.id}
	<br> sessionScope::
	<%=session.getAttribute("name")%>
	<br> applicationScope::
	<%=application.getAttribute("name")%>
	<br>
</body>
</html>
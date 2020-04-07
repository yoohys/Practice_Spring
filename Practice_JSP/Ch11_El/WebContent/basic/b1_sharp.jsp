<%@page import="basic.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>값을 계싼할떄 바로 계싼</title>
</head>
<body>
	<%
		Member m = new Member();
		m.setName("이름1");
	%>
	<c:set var="m" value="<%=m %>"></c:set>
	<c:set var="name" value="#{m.name}"></c:set>
	m.getName() :: <%=m.getName() %>	<Br>
	<hr>
	<%m.setName("이름2"); %>
	\${name} :: ${name }<br>
	<%m.setName("이름3") ;%>
		\${name} :: deffered Expression(실제로 값이 필요한 시점에 값을 계산)${name }<br>
</body>
</html>
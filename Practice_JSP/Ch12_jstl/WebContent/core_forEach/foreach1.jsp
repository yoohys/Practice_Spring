
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10" step="1">
      <c:out value="${i}" />
</c:forEach>
<hr>
<c:forEach var="i" begin="1" end="7" step="1">
      <c:out value="${i}" />
</c:forEach>
<hr>
<% 
	ArrayList<String> name = new ArrayList<>();
	name.add("홍길동");
	name.add("이순신");
	name.add("유관순");
%>
<c:forEach var="name" items="<%=name%>" >
     ${name}
</c:forEach>
<hr>

<%
	ArrayList<String> basic = new ArrayList<>();
	basic.add("A");
	basic.add("B");
	basic.add("C");
	basic.add("D");
%>
<c:forEach var ="basic" items="<%=basic %>">
	${basic } <br/>
</c:forEach>








</body>
</html>
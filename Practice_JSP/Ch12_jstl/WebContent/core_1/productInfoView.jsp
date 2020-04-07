<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
<h4>상품정보(EL)</h4>
 상품코드:: ${CODE }<br>
 상품명::  ${NAME }  <br>
 단가::    ${PRICE } <br>
<h4>상품정보(JSTL)</h4>
 상품코드:: <c:out value="${CODE }"></c:out><br>
 상품명::  <c:out value="${NAME }"></c:out>  <br>
 단가::    <c:out value="${PRICE }"></c:out>   <br>
 <hr>
 request.getAttribute("name")::<%=request.getAttribute("name") %><br>
 request.getParameter("name")::<%=request.getParameter("name") %><br>
 \${param.name }:: ${param.name }<br>
 <c:out value="<%=name %>"></c:out>
 <c:out value="${param.name }"></c:out>
<%--  <c:out value="${name }"></c:out> --%>
</body>
</html>










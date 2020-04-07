<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="login" value="${param.id }"></c:set>
	${login }
	<br>
	<c:choose>
		<c:when test="${login == 'admin'}">관리자입니다.</c:when>
		<c:when test="${login == 'guest'}">guest입니다.</c:when>
		<c:when test="${empty login}">로그인하세요.</c:when>
		<c:otherwise>일반회원입니다.</c:otherwise>
	</c:choose>
</body>
</html>
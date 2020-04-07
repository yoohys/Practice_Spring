<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 예제</title>
</head>
<body>
<c:if test="${! empty authUser}">
	${authUser.name}님 안녕하세요
	<a href="logout.do">[LOGOUT]</a>
	<a href="changePwd.do">[Change PW]</a>
	<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
	<a href="${ctxPath}/article/list.do">[View Board]</a>
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[JOIN]</a>
	<a href="login.do">[LOGIN]</a>
</c:if>
<br/>
</body>
</html>
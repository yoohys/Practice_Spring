<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login.do" method="post">
<c:if test="${errors.idOrPwNotMatch}">
아이디와 암호가 일치하지 않습니다.
</c:if>
<p>
	ID : <br/><input type="text" name="id" value="${param.id}">
	<c:if test="${errors.id}">ID를 입력하세요</c:if>
</p>
<p>
	PW : <br/><input type="password" name="password">
	<c:if test="${errors.password}">PW를 입력하세요</c:if>
</p>
<input type="submit" value="LOGIN">
</form>
</body>
</html>
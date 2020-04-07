<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Complete</title>
</head>
<body>
${param.name}님, 회원 가입에 성공했습니다.<br/>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<a href="${ctxPath}/login.do">[Login하러가기]</a>
</body>
</html>
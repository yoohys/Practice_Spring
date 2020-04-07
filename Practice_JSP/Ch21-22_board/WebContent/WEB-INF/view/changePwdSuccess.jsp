<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 변경</title>
</head>
<body>
	암호를 변경했습니다.
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<a href="${ctxPath}/login.do">[View Board]</a>
</body>
</html>
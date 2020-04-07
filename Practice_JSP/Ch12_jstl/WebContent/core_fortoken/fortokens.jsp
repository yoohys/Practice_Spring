<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>forTokens</h4>
<c:set var="dept" value="/컴퓨터/기계/자동차/간호"></c:set>
<c:set var="subj" value="SQL,JSP,SPring/R/Python"></c:set>
학과:${dept } <br>
과목명:${subj } <br>
<hr>
<c:forTokens var="i" items="${dept }" delims="/" varStatus="vs">
	<c:out value="${vs.count }.${i }"/><br>
</c:forTokens>
<hr>
<c:forTokens var="name" items="${subj }" delims=",/" varStatus="vs">
	<c:out value="${vs.count }.${name }"/><br>
</c:forTokens>
</body>
</html>


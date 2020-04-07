<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="greeting" value="How Are You"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
본래의 문자열: ${greeting }<br>
모두 대문자 : ${fn:toUpperCase(greeting) }<br>
모두 소문자 : ${fn:toLowerCase(greeting) }<br>
Are의 위치는 : ${fn:indexOf(greeting,"Are") }<br>
문자열의 길이는 : ${fn:length(greeting) }
</body>
</html>
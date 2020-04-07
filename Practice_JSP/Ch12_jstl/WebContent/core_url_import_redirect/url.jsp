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
	<c:url var="url1" value="http://www.google.com"></c:url>
	<c:url var="url2" value="../core_choose/login_choose.jsp">
	<c:param name="id" value="guest"></c:param>
	</c:url>
	
<ul>
<li>url1=${url1 }</li>
<li>url2=${url2 }</li>

</ul>
<a href=<c:out value="${url2 }"/>>url2</a>
</body>
</html>
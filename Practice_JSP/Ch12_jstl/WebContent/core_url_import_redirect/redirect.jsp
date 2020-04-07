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
<c:redirect url="multi_redirect.jsp" >
<c:param name="NUM1" value="5"></c:param>
<c:param name="NUM2" value="25"></c:param>
</c:redirect>
</body>
</html>
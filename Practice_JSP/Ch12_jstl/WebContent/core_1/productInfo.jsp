<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl</title>
</head>
<body>
<c:set var="CODE" value="1111" scope="request"></c:set>
<c:set var="NAME" value="강아지" scope="request"></c:set>
<c:set var="PRICE" value="1000" scope="request"></c:set>

<jsp:forward page="productInfoView.jsp">
	<jsp:param value="hong" name="name"/>
</jsp:forward>
</body>
</html>







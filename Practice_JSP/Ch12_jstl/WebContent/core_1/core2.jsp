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
<c:set var="login" value="abcd" scope="session"></c:set>
<c:set var="passwd" value="1234" />
<h4>변수선언&출력</h4>
Session::<%=session.getAttribute("login") %><br>
Login:: <c:out value="${login }"/><br>
Password::<c:out value="${passwd }"/><br>
<hr>
<c:remove var="login" scope="session"/>
Login:: <c:out value="${login }"/><br>
<h4>오류메시지 출력</h4>
10/0=
<c:catch var="errmsg"><%=10/0 %></c:catch>
<c:out value="${errmsg }"></c:out>
</body>
</html>





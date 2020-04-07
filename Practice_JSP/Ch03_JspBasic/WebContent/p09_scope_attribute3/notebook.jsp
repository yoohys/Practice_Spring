<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("장바구니2", "노트북");
	int i = (int) application.getAttribute("click");
	application.setAttribute("click", i + 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노트북 구입 페이지</title>
</head>
<body>
	<h3>노트북을 장바구니에 담았습니다.</h3>
	<a href="car.jsp">자동차 매장으로 가기</a>
</body>
</html>
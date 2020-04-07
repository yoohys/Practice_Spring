<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("장바구니3", "자동차");
	int i = (int) application.getAttribute("click");
	application.setAttribute("click", i + 1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 구입페이지</title>
</head>
<body>
	<h3>자동차를 장바구니에 담았습니다.</h3>
	<a href="showCart.jsp">장바구니 내용보기</a>
</body>
</html>
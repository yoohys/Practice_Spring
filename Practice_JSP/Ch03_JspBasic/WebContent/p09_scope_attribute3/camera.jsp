<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카메라 구입 페이지</title>
</head>
<body>
	<h3>카메라를 장바구니에 담았습니다.</h3>
	<a href="notebook.jsp">노트북 매장가기</a>
	<%
		session.setAttribute("장바구니1", "카메라");
	int i= (int) application.getAttribute("click");
	application.setAttribute("click", i+1);
	%>
</body>
</html>
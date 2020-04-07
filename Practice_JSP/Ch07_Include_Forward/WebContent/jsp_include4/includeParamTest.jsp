<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = "홍길동";
		String pageName = "includedParamTest.jsp";
	%>
	포함하는 페이지 includeParamTest.jsp입니다.
	<br> 포함되는 페이지 parameter값을 전달합니다.
	<br>
	<hr>
	<jsp:include page="<%=pageName %>" flush="false">
	<jsp:param value="<%=name %>" name="name" />
	<jsp:param value="<%=pageName %>" name="pageName" />
	</jsp:include>
</body>
</html>
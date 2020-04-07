<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("email", request.getParameter("email"));
	session.setAttribute("addr", request.getParameter("addr"));
	session.setAttribute("pnum", request.getParameter("pnum"));
%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
		text-align: center;
}
</style>
<meta charset="UTF-8">
<title>attribute Test</title>
</head>
<body>
	<%
		String name2 = (String) application.getAttribute("name");
		String id2 = (String) application.getAttribute("id");
	%>
	<h3>영역과 속성 테스트</h3>
	<%=name2%>님의 정보가 모두 저장 되었습니다.
	<a href="attributeTest3.jsp">확인하러 가기</a>
</body>
</html>
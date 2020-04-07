<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	application.setAttribute("name", request.getParameter("name"));
	application.setAttribute("id", request.getParameter("id"));
%>
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
<title>Insert title here</title>
</head>
<body>
	<%
		String name1 = (String) application.getAttribute("name");
		String id1 = (String) application.getAttribute("id");
	%>
	<form action="attributeTest2.jsp" method="post">
		<h3>영역과 속성 테스트</h3>
		<%=name1%>님 반갑습니다.
		<%=name1%>님의 아이디는
		<%=id1%>입니다.
		<hr>
		<table>
			<tr>
				<td colspan="2">session 영역 저장 내용들</td>
			</tr>
			<tr>
				<th>email 주소</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>집주소</th>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="pnum"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>




		</table>

	</form>

</body>
</html>
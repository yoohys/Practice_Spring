<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2">Application 영역 저장 내용들</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=application.getAttribute("name")%></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=application.getAttribute("id")%></td>
		</tr>


	</table>
	<hr>
	<table>
		<tr>
			<td colspan="2">session 영역 저장 내용들</td>
		</tr>
		<tr>
			<th>email 주소</th>
			<td><%=session.getAttribute("email")%></td>
		</tr>
		<tr>
			<th>집주소</th>
			<td><%=session.getAttribute("addr")%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=session.getAttribute("pnum")%></td>
		</tr>

	</table>
</body>
</html>
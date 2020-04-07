<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	if (type == null)
		return;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="80%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>타입</td>
			<td><%=type%></td>
		</tr>
		<tr>
			<td>특징</td>
			<td>
				<%
					if (type.equals("A")) {
				%> 강한 내구성 <%
					} else if (type.equals("B")) {
				%> 뛰어난 대처능력 <%
					}
				%>
			</td>
		</tr>

	</table>

</body>
</html>
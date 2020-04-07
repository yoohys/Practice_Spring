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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String type = request.getParameter("type");
		
	
		if (type.equals("관리자")) {
	%><jsp:forward page="managerMain.jsp"></jsp:forward>
	<%
		} else {
	%><jsp:forward page="userMain.jsp"></jsp:forward>
	<%
		}
	%>
</body>
</html>
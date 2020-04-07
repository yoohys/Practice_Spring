<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP:out객체</title>
</head>
<body>
	버퍼크기:<%=out.getBufferSize()%><br> 남은크기:<%=out.getRemaining()%><br>
	<%
		String name = "hong";
		out.print(name + "입니다.");
	%><br> 버퍼크기:<%=out.getBufferSize()%>
	
	<%System.out.println(name+"입니다"); %>
</body>
</html>
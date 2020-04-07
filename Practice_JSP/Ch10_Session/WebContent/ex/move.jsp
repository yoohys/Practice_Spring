<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>ID는 
<%=session.getAttribute("id") %> PASSWORD는 
<%=session.getAttribute("pw") %> 입니다.
</body>
</html>
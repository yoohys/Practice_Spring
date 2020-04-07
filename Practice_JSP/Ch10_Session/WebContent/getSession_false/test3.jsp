<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session= request.getSession(false);
if(session != null)
session.invalidate();
response.sendRedirect("index.jsp");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
request.getSession():: 현재 세션이 존재하면 기존세션을 리턴, 없으면 새로생성<br>
request.getSession(true):: request에 대한 새로운 세션을 생성 후 리턴<br>
request.getSession(false):: 현재세션이 존재하면 기존세션을 리턴, 없으면 Null<br>
</body>
</html>
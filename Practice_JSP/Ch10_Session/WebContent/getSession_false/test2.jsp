<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Attribute ID 값 : <%=request.getSession().getAttribute("id") %><br>
isNew() : <%=session.isNew() %><br>
세션 ID : <%=session.getId() %><br>
세션생성시간 : <%=new java.util.Date(session.getCreationTime()).toString() %><br>
세션마지막접속시간 : <%=new java.util.Date(session.getLastAccessedTime()).toString() %><br>
<a href="test3.jsp">세션삭제하기</a>
</body>
</html>
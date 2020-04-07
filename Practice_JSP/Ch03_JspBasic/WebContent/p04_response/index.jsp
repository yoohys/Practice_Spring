<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String name =request.getParameter("memberid"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 출력(JSP) :: <%=request.getParameter("memberid") %><hr>
아이디 출력(EL(name)) :: $(name}<hr>
아이디 출력(EL(param:name)) :: ${param.memberid}<hr>
</body>
</html>
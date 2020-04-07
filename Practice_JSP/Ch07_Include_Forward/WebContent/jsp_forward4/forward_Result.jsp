<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>이름</td><td><%=request.getParameter("name") %></td></tr>
<tr><td>나이</td><td>${param.age }</td></tr>
<tr><td>주소</td><td>${param.addr }</td></tr>
<tr><td>전화번호</td><td>${param.tel}</td></tr>
</table>
</body>
</html>
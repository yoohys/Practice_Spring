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
Cookie c = new Cookie("MyCookie","admin");
response.addCookie(c);
c.setMaxAge(-1); //브라우저가 닫히기 전까지 쿠키 생존

%>

MyCookie 쿠키 값 : ${cookie.MyCookie.value }<br>
MyCookie 쿠키 값 : ${cookie['MyCookie']['value']}<br>
MyCookie 유지 시간 : ${cookie['MyCookie']['maxAge'] }<br>
MyCookie 쿠키 : ${cookie.MyCookie}<br>



</body>
</html>
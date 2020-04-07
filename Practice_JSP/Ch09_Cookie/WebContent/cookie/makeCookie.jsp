<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie c = new Cookie("name", "홍길동");
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생성</title>
</head>
<body>
	Cookie:: 웹브라우저가 보관하고있는 데이터로 웹서버에 요청 시 쿠키를 함께 전송해서 방문증명을 면제
	<br> 웹서버는 전송받은 쿠키를 사용해서 필요한 데이터를 읽어 올수 있다.
	<br> API: javax.servlet.http.Cookie
	<hr>쿠키 이름 : <%=c.getName() %>   쿠키 값 : <%=c.getValue() %>

</body>
</html>
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
		Cookie[] c = request.getCookies();
		if (c != null && c.length > 0) {
			for (int i = 0; i < c.length; i++) {
				if (c[i].getName().equals("name")) {
					//modify 객체 생성으로 변경;
					Cookie cookie = new Cookie("name", "hong2");
					response.addCookie(cookie);
				}
			}
		}
	%>
	name쿠키값을 변경합니다.
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="jsp2.MemberInfo" scope="request"></jsp:useBean>
<%
	member.setId("abcd");
	member.setName("홍길동");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="useObject.jsp"><jsp:param
			value="Alphago" name="name" />
	</jsp:forward>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String str = "전역변수입니다.(!)";%>
	<%
		String str2 = "지역변수입니다.()";
	%>
	<!-- 	함수선언: 반드시(!) -->
	<%!String getStr() {
		return str; //지역변수는 함수안에서 사용불가
	};%>



	<%=str%><br>
	<%=str2%><br>
	<%=getStr()%><br>
</body>
</html>
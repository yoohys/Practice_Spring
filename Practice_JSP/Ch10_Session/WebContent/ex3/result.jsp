<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 가입 결과</h2>
<%if(request.getParameter("result").equals("success")){
	%>	<h4>가입 되었습니다.</h4><%
}else{%>
	<h4>가입이 실패되었습니다.</h4><% 
}%>
	
	


</body>
</html>
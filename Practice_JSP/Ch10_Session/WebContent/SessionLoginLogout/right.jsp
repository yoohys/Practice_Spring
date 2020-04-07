<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh">
<title>Insert title here</title>
</head>
<body>
<h2>RIGHT.JSP</h2><%
if(session.getAttribute("id")!=null){
%><img src="z.jpg" alt="그림이 사라짐">
<%}else{
	%><h2>로그인 되어있지 않은 상태입니다.</h2><% 
}
%>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setContentType("text/html; charset=UTF-8");

 String id = request.getParameter("id");
 String pw = request.getParameter("pw");
 session.setAttribute("id", id);
 session.setAttribute("pw", pw);

 String UserID="hong";
 String UserPS="1234";
 String UserName="홍길동";
 
 
 if(id.equals(UserID)){
	 session.setAttribute("ID", UserID);
 }
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "move.jsp">여기</a>를 클릭하세요 

</body>
</html>
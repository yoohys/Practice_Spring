
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>로그인 정보</h4>
아이디: <%=request.getParameter("id") %><br>
아이디(EL): ${param.id}<br>
비밀번호: <%=request.getParameter("pw") %><br>
쿠키헤더: <%=request.getHeader("Cookie") %><br>
<%
Cookie[] c = request.getCookies();
if(c!=null&&c.length>0){
	for(int i =0; i<c.length; i++){
		%>쿠키이름 : <%=c[i].getName()%> 값 : <%=c[i].getValue() %> <br>
	<%}
}
%>
</body>
</html>
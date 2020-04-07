<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="jsp2.MemberInfo" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:
JSP : JAVA : <%=member.getName() %>회원님 안녕하세요! <br>
JSP : EL : ${member.name }<br>
JSP: UseBean : <jsp:getProperty property="name" name="member"/><br>
JSP: Parameter : <%=request.getParameter("name") %><br>
JSP: Attribute : <%=request.getAttribute("name") %>
</body>
</html>
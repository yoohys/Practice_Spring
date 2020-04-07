<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="jsp1.BeanTest" %>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="testid" class="jsp1.BeanTest">
    <jsp:setProperty name="testid" property="id"/>
    <jsp:setProperty name="testid" property="pw"/>
    <jsp:setProperty name="testid" property="name"/>
    <jsp:setProperty name="testid" property="age"/>
    <jsp:setProperty name="testid" property="sex"/>
    <jsp:setProperty name="testid" property="email"/>
        
    </jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 정보 확인 페이지</title>
<style>
td{font-size:120%}
</style>
</head>
<body>

<table border=1>
<tr><td>아이디 :</td><td> <jsp:getProperty property="id" name="testid"/></td></tr>
<tr><td>비밀번호 :</td><td>${join.pw }</td></tr>
<%-- <tr><td>비밀번호 :</td><td><jsp:getProperty property="pw" name="testid"/></td> --%>
<tr><td>이름 :</td><td><jsp:getProperty property="name" name="testid"/></td></tr>
<tr><td>성별 :</td><td><jsp:getProperty property="sex" name="testid"/></td></tr>
<tr><td>나이 :</td><td><jsp:getProperty property="age" name="testid"/></td></tr>
<tr><td>이메일주소 :</td><td><jsp:getProperty property="email" name="testid"/></td></tr>

</table>
</body>
</html>
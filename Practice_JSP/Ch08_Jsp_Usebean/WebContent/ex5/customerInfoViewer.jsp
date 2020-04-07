<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pinfo" class="jsp2.PersonalInfo" scope="request">
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>이름 : ${pinfo.name} <br>성별 : <jsp:getProperty property="gender" name="pinfo"/> <br>나이 : ${pinfo.age }
</body>
</html>
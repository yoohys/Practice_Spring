<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>otherScope.jsp파일 보기</title>
</head>
<body>
	<h3>scope.jsp데이터 보기</h3>

	pageName의 속성값(JSP)::
	<%=pageContext.getAttribute("pageName")%><br> pageName의 속성값(EL)::
	${pageScope.pageName}
	<br> request의 속성값(EL):: ${requestScope.requestName}
	<br> session의 속성값(EL):: ${sessionScope.sessionName}
	<br> application의 속성값(EL):: ${applicationScope.applicationName}
	<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language: 표현언어)</title>
</head>
<body>
	<%
		//현재 페이지에 저장
		pageContext.setAttribute("pageName", "page값");
		//http 요청한 페이지 및 이동할 페이지(include,forward)
		request.setAttribute("requestName", "request값");
		//하나의 웹브라우저가 켜진상태에서 있는 페이지 저장
		session.setAttribute("sessionName", "session값");
		//서버가 켜져 있는동안 페이지 저장
		application.setAttribute("applicationName", "application값");
	%>

	pageName의 속성값(JSP)::
	<%=pageContext.getAttribute("pageName")%><br>
	
	pageName의 속성값(EL)::
	${pageScope.pageName} <br>
	request의 속성값(EL)::
	${requestScope.requestName} <br>
	session의 속성값(EL)::
	${sessionScope.sessionName} <br>
	application의 속성값(EL)::
	${applicationScope.applicationName} <br>
</body>
</html>
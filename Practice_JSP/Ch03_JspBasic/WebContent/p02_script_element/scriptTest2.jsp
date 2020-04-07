<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String declaration = " 선언문 연습입니다.";%>
	<%!public String declarationMethod() {
		return declaration;
	}%>
	<%
		// JSP 한줄주석 (Java)
		/* jsp 여러줄 주석 (Java)*/
		String scriptlet = " 스크립트 연습";
		String comment = " 주석문 연습";
		out.println("내장객체를 이용한 출력:" + declaration + "</p>");
	%>
	<p>
		선언문출력하기 (전역변수) :
		<%=declaration%></p>
	<p>
		선언문출력하기 (메소드) :
		<%=declarationMethod()%></p>
	<p>
		선언문출력하기 (지역변수) :
		<%=scriptlet%></p>
	<!-- 	html 한줄 주석 -->
	<hr>
	<!-- 	<%=comment%> -->
	<%=comment%>
	<%-- 	Jsp주석 <%=comment%> --%>

</body>
</html>
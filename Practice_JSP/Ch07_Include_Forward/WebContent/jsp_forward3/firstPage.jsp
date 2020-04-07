<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>first page</h3>
	<%
		pageContext.setAttribute("name", "page");
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		application.setAttribute("name", "application");
		out.print("하나의 페이지 속성: " + pageContext.getAttribute("name"));
		out.print("하나의 요청 속성: " + request.getAttribute("name"));
		out.print("하나의 세션 속성: " + session.getAttribute("name"));
		out.print("하나의 어플리케이션 속성: " + application.getAttribute("name"));

		request.getRequestDispatcher("secondPage.jsp").forward(request, response);
	%>
	<!-- 	forward로 가버리기 떄문에 이후의 내용은 표시되지않음 -->
	하나의 페이지 속성:
	<%=pageContext.getAttribute("name")%><br> 하나의 요청 속성:
	<%=request.getAttribute("name")%><br> 하나의 세션 속성:
	<%=session.getAttribute("name")%><br> 하나의 어플리케이션 속성:
	<%=application.getAttribute("name")%><br>
</body>
</html>
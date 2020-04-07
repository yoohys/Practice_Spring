<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     우선순위 가장 높다 -->
<%-- <%@ page errorPage="error.jsp"%>     --%>
<%
	Date d =  new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String strdate = sdf.format(d);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 고의로 에러를 발생시킨 라인으로 strdate변수명을 strdat로 틀리게 입력했을때(컴파일 에러):500 -->
오늘 날짜는 <%=strdate %>
<hr>
name parameter ::<%=request.getParameter("name").toUpperCase() %>
</body>
</html>












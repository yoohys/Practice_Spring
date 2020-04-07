<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" 
contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"
 session="true"
 buffer="8kb"
 autoFlush="true"
 isThreadSafe="true"
 info="copywright by Hong"
 %>
 
 <%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Page Directive</h2>
<%
//     scriptlet :: 자바코드 실행시
	Timestamp now = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = sdf.format(now);
%>
오늘은<%=strDate %>입니다.::이것은 표현식(Expression:값 출력)<br>
<!-- 오늘은 2019-09-30입니다. -->

<%=getServletInfo() %><br>
contentType::<%="한글이 제대로 표시됩니다." %><br>
session::<%="이 페이지는 세션이 유지되는 페이지 입니다." %>
<hr>
선언부는 함수나 변수 선언시 사용<br>


</body>
</html>












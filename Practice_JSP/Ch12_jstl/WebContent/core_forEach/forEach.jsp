<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSTL Core 라이브러리 실습</title>
</head>
<body>
<h4>JSTL Core 라이브러리 실습1(배열저장:1~10)</h4>
<%
    int [] num = { 1 ,2 , 3 ,4, 5 , 6 , 7, 8, 9, 10 };
    request.setAttribute("myArray", num);
%>
<c:forEach var="n" items="${myArray}">
  <c:out value="${n}" />
</c:forEach>
<br>
<c:forEach var="n" items="${myArray}" begin="0" end="6">
  <c:out value="${n}" />
</c:forEach>

<h4>JSTL Core 라이브러리 실습2(ArrayList: 홍길동,이순신, 유관순)</h4>
<%
   
    ArrayList<String> list = new ArrayList<String>();
    list.add("홍길동");
    list.add("이순신");
    list.add("유관순");
    request.setAttribute("name", list);
%>
<c:forEach var="n" items="${name}">
  <c:out value="${n}" />
</c:forEach>
<h4>JSTL Core 라이브러리 실습3 (String: A,B,C,D)</h4>

<%
    String str = "A,B,C,D";
    request.setAttribute("data", str);
%>
<c:forTokens var="n" items="${data}" delims="," >
     <c:out value="${n}" /><br>
</c:forTokens>
</body>
</html>

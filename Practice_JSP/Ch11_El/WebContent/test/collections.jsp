<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] str = new String[]{"컴공","정통","경영","행정"};

ArrayList al = new ArrayList();
al.add(0, "SQL응용");
al.add(1, "JSP/Servlet");
al.add(2, "ERP정보시스템");

Map<String,String> m = new HashMap();
m.put("학과","컴퓨터공학과");
m.put("성명","강준상");
m.put("직위","교수");
m.put("전화","010-123-4567");


pageContext.setAttribute("str", str);
pageContext.setAttribute("al", al);
pageContext.setAttribute("m", m);
%>

${str[0] }<br>
${str[1] }<br>
${str[2] }<br>
${str[3] }<br>
${al[0] }<br>
${al[1] }<br>
${al[2] }<br>
${m.get("학과") }<br>
${m.get("성명") }<br>
${m.get("직위") }<br>
${m.get("전화") }<br>


</body>
</html>
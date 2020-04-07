<%@page import="org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID"%>
<%@page import="util.Thermometer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Thermometer t = new Thermometer();
request.setAttribute("t", t);

%>

${t.setCelsius('서울',27.3) }
서울온도 = 섭씨 ${t.getCelsius('서울')}도 = 화씨 ${t.getFahrenheit('서울') } <br>
정보 = ${t.info }
</body>
</html>
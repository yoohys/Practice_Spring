<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var = "now" value="<%=new Date() %>"></c:set>
<h4>한국</h4>
금액 : <fmt:formatNumber value="10000000" type="currency"></fmt:formatNumber><br>
일시 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" />
<hr>
<h4>미국</h4>
<fmt:setLocale value="en_us"/>
금액 : <fmt:formatNumber value="10000000" type="currency"></fmt:formatNumber><br>
일시 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" />
<hr>
<h4>일본</h4>
<fmt:setLocale value="ja_jp"/>
금액 : <fmt:formatNumber value="10000000" type="currency"></fmt:formatNumber><br>
일시 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" />
</body>
</html>
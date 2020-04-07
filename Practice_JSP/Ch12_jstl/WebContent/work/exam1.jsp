<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSTL fmt 라이브러리 실습</title>
</head>
<body>
<h1>JSTL fmt 라이브러리 실습</h1>
<c:set var="now" value="<%=new java.util.Date() %>"/>
${now }<br>
<fmt:formatDate value="${now }" pattern="yyyy.MM.dd"/><br>
<fmt:formatDate value="${now }" type="time"/><br>
<fmt:formatDate value="${now }" type="date" dateStyle="short" pattern="yyyy.MM.dd"/>
<fmt:formatDate value="${now }" type="time"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="full" /><br>
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="short" /><br>
<h1>JSTL fmt 라이브러리 실습 2</h1>
<fmt:formatNumber value="10000000" type="currency"/><br>
<fmt:formatNumber value="0.12" type="percent" /><br>
<fmt:formatNumber value="98765432112" maxFractionDigits="3" />
</body>
</html>

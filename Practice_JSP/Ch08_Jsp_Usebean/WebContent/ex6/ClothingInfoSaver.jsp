<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>의류 정보가 저장되었습니다.</h4>
<jsp:useBean id="pinfo" class="jsp3.BookInfo" scope="request">
</jsp:useBean>
<%
pinfo.setCode("70002");
pinfo.setName("반팔 티셔츠");
pinfo.setPrice(15000);
%>
<hr>
<jsp:include page="ProductInfo.jsp"/>
</body>
</html>
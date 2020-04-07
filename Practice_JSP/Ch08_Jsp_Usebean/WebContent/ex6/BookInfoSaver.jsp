<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>책 정보가 저장되었습니다.</h4>
<jsp:useBean id="pinfo" class="jsp3.BookInfo" scope="request">
</jsp:useBean>
<%
pinfo.setCode("50001");
pinfo.setName("의뢰인");
pinfo.setPrice(9000);

%>
<hr>
<jsp:include page="ProductInfo.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="jsp3.ProductInfo" id="pinfo" scope="request" />
<h3>제품 개략 정보</h3>
코드: <jsp:getProperty name="pinfo" property="code" /> <BR>
제품명:<jsp:getProperty name="pinfo" property="name" /> <BR>
가격: <jsp:getProperty name="pinfo" property="price" /> <BR>

</body>
</html>
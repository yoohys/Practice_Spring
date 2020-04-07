<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합의 결과 출력(EL)</title>
</head>
<body>
JSP :: <%=request.getAttribute("result") %><br>
<%-- ${param.result }  파라미터가 아니므로 불가--%>
EL :: ${result}<br>
</body>
</html>
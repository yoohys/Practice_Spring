<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="true" %>
<%
request.setAttribute("name", "홍길동");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
요청 URI :: ${pageContext.request.requestURI }<br>
request의 name 속성 ::${requestScope.name } <br>
code Parameter :: ${param.code }<br>
<hr>
EL 비활성화 하는 방법1 : web.xml <br>
EL 비활성화 하는 방법2 : @page : ignored <br>

</body>
</html>
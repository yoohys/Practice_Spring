<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
X= ${param.NUM1 },Y=${param.NUM2 }<br>
X+Y= ${param.NUM1 }+${param.NUM2 }<br>
X가 더 큽니까? = ${param.NUM1 >param.NUM2? "맞습니다":"틀립니다"}<br>
X가 더 큽니까? = ${param.NUM1 -param.NUM2 >0 }<br>
X와 Y가 같습니까? = ${param.NUM1==param.NUM2? "맞습니다":"틀립니다" }<br>
<hr>
나눈몫 = ${param.NUM1 div param.NUM2 }<br>
나머지 = ${param.NUM1 mod param.NUM2 }<br>
둘다 양수입니까? = ${(param.NUM1 gt 0 ) and (param.NUM2 gt 0 )}<br>
<hr>
숫자 = ${empty param.NUM1? "guest" : "admin" }<br>
</body>
</html>
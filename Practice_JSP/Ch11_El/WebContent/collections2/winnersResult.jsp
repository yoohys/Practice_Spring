<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

(1) 배열 출력<br>
${s[0] } <br>
${s[1] } <br>
${s[2] } <br>
<hr>
(2) List 출력<br>
${List[0] } <br>
${List[1] } <br>
${List[2] } <br>
<hr>
(3) Map 출력<br>
${m.get("홍길동1") } <br>
${m.get("홍길동2") } <br>
${m.get("홍길동3") } <br>
<hr>
(4) JavaBean 출력<br>
${pi.getName()} <br>
${pi.getValue()} <br>
<hr>
(5) 객체를 묶어서 출력<br>
${lb[0]} <br>
${lb[1]} <br>

</body>
</html>
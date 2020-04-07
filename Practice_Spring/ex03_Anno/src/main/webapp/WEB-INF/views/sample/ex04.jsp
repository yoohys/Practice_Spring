<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
@ModelAttribute를 사용하지 않은 방식인 경우::<br>
SampleDTO 객체이름 : 소문자(sampleDTO)로 내부생성<br>
@ModelAttribute 사용하면 param을 쓰지 않은 page도 출력됨.
<h2>SAMPLEDTO ${sampleDTO }</h2>
<h2>PAGE ${page }</h2>
<h2>PAGE(param) ${param.page }</h2>

</body>
</html>
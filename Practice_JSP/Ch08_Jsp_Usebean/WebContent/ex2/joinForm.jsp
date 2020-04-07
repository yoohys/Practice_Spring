<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<style type="text/css">
table {
	border: 0px
}
</style>

</head>
<body>
	<form action="joinChk.jsp" method="post">
		아이디 : <input type="text" name="id"><br> 비밀번호 : <input
			type="password" name="pw"><br> 이름 : <input type="text"
			name="name"><br> 성별 : <input type="radio" name="sex"
			value="남자"> 남자  <input type="radio" name="sex" value="여자"> 여자 <br>
		나이 : <input type="number" name="age"><br> 이메일주소 : <input
			type="text" name="email"><br> <input type="submit"
			value="가입"><input type="reset" value="다시 작성">

	</form>
</body>
</html>
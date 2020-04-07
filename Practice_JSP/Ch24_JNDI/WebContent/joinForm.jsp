<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리 시스템 회원가입 페이지</title>
</head>
<body>
<form name="joinform" action="joinProcess.jsp" method="post">

<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b>회원가입 페이지</b>
		</td>
	</tr>
	<tr><td>아이디 : </td><td><input type="text" name="id"/></td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" name="pass"/></td></tr>
	<tr><td>이름 : </td><td><input type="text" name="name"/></td></tr>
	<tr><td>나이 : </td><td><input type="text" name="age" maxlength=2 size=5/></td></tr>
	<tr>
		<td>성별 : </td>
		<td>
			<input type="radio" name="gender" value="남" checked/>남자
			<input type="radio" name="gender" value="여"/>여자
		</td>
	</tr>
	<tr><td>이메일 주소 : </td><td><input type="text" name="email" size=30/></td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>

</form>
</body>
</html>

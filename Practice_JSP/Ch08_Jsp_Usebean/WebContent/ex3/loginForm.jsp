<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%response.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>

<head>
<script type="text/javascript">
	function In_Check() {

		if (document.login.id.value == "") {
			alert("아이디를 입력하세요!")
			return;
		}
		if (document.login.pw.value == "") {
			alert("비밀번호를 입력하세요!")
			return;
		}
		document.login.submit();
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>로그인 화면 설계</h4>
	<form name="login" method="post" action="loginProcess.jsp">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="로그인"
					onclick="In_Check()"> <input type="reset" value="취소"
					onclick=""></td>
			</tr>
		</table>
	</form>
</body>
</html>
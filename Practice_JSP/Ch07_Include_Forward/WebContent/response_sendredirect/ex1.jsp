<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session객체</title>
</head>
<body>
	아이디를 입력하세요
	<form>
		<table>
			<tr>
				<td>아이디::<input type="text" name="id"> <input
					type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	<%
		String user = " ";
		if (request.getParameter("id") != null) {
			user = request.getParameter("id");
			session.setAttribute("id", user);
			response.sendRedirect("ex2.jsp?id=hong");
			//parameter를통하여 값 전달하기
		}
	%>
</body>
</html>
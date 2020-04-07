<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="requestTestPro.jsp" method="post">
		<h1>학번,이름,학년,선택과목을 입력하는 폼</h1>
		<ul>
			<li>학번 : <input type="number" name="snum"></li>
			<li>이름 : <input type="text" name="sname"></li>
			<li>학년 : <input type="radio" name="stun" value="1학년">1학년<input
				type="radio" name="stun" value="2학년">2학년<input type="radio"
				name="stun" value="3학년">3학년<input type="radio" name="stun"
				value="4학년">4학년
			</li>
			<li>과목 : <select name="sub"><option value="JAVA">JAVA</option>
					<option value="PYTHON">PYTHON</option>
					<option value="C++">C++</option></select>
			</li>
		</ul>
		<input type="submit" value="입력완료">
	</form>
</body>
</html>
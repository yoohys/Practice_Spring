<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idSubmit(){
	document.idForm.action= 'test1.jsp';
	document.idForm.submit();
}

</script>
</head>
<body>
isNew(): <%=session.isNew() %><br>
::해당 세션이 처음 생성되었으면 true값을 반환하고, 이전에 생성된 세션이면 false반환<br>
<form name="idForm" method="post">
	<input type="text" name="id" size="15">
	<input type="button" value="확인" onclick="idSubmit()">
</form>
</body>
</html>
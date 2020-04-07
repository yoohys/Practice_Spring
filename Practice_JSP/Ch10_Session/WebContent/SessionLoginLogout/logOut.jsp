<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var con = confirm("정말로 로그아웃 하시겠습니까");
if(con == true){
  <%session.invalidate(); %>
  location.href = "left.jsp";
}
else if(con == false){
	
history.back();

  
}
</script>
</body>
</html>
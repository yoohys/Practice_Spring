<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");

    session.setAttribute("id", id);
    session.setAttribute("pw", pw);
    session.setAttribute("name", name);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><form action="subscribe.jsp" method="post">
<h2> 약관</h2>
<hr>
1. 회원 정보는 웹사이트의 운영을 위해서만 사용됩니다.
2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다.
<hr>
위의 약관에 동의하십니까? <input type="radio" value="yes" name="agree"> 동의함 
<input type="radio" value="no" name="agree"> 동의하지 않음
<input type="submit" value="확인">
</form>
 </body>
</html>
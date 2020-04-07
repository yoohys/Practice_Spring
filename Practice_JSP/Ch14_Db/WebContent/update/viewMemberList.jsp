<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<table>
<tr>
<td>이름</td>
<td>아이디</td>
<td>이메일</td>
</tr>
<%
//1.JDBC 드라이버 로딩
Class.forName("com.mysql.jdbc.Driver");
Connection conn =null;
Statement stmt = null;
ResultSet rs = null;
try{
String url="jdbc:mysql://localhost:3306/jsp_db?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
String dbUser="jsp_db";
String dbPass="jsp_db";
String query = "select * from jsp_db.member order by id";

//2. 데이터베이스 커넥션 생성
conn = DriverManager.getConnection(url,dbUser,dbPass);

//3. Statement 생성
stmt = conn.createStatement();

//4. Query 실행
rs = stmt.executeQuery(query);

//5. Query 실행 결과 출력
while(rs.next()){
%>
<tr>
<td><%=rs.getString("name") %></td>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("email") %></td>
</tr><%} }catch(Exception e){
out.print(e.getMessage());
}finally{
	//6. 사용한 Statement 종료
	if(rs!=null)try{rs.close();} catch(SQLException e){}
	if(stmt!=null)try{stmt.close();} catch(SQLException e){}
	if(conn!=null)try{conn.close();} catch(SQLException e){}
}

%>
</table>

</body>
</html>
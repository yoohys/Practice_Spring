<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.Reader"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");


//1.JDBC 드라이버 로딩
Class.forName("com.mysql.jdbc.Driver");
Connection conn =null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	
String url="jdbc:mysql://localhost:3306/jsp_db?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
String dbUser="jsp_db";
String dbPass="jsp_db";
String query = "select * from jsp_db.member_history where id = ?";

//2. 데이터베이스 커넥션 생성
conn = DriverManager.getConnection(url,dbUser,dbPass);

//3. Statement 생성
pstmt = conn.prepareStatement(query);
pstmt.setString(1, id);

//4. Query 실행
rs = pstmt.executeQuery();

//5. Query 실행 결과 출력
if(rs.next()){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<table border="1">
<tr>
<td>아이디</td><td><%=id %></td>
</tr>

<tr>
<td>히스토리</td>
<td><%
String  history = null;
Reader reader = null;

try{
	reader = rs.getCharacterStream("history");
	
	if(reader!=null){
		StringBuilder buff = new StringBuilder();
		char[] ch = new char[512];
		int len =-1;
		while((len=reader.read(ch))!=-1){
			buff.append(ch,0,len);
		}
		history = buff.toString();
	}
	
	
	
}catch(IOException ex){
	out.println("익셉션 발생:"+ex.getMessage());
	
}finally{
	if(reader!=null) try{reader.close();
}catch(IOException ex){}
}


%>
<%=history %>
</td></tr></table>

<%

}else{%>
<%=id%>회원의 히스토리가 없습니다.

<% } }catch(Exception e){
out.print(e.getMessage());
}finally{
	//6. 사용한 Statement 종료
	if(rs!=null)try{rs.close();} catch(SQLException e){}
	if(pstmt!=null)try{pstmt.close();} catch(SQLException e){}
	if(conn!=null)try{conn.close();} catch(SQLException e){}
}

%>
</body>
</html>
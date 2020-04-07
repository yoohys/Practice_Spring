<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String pw = request.getParameter("pw");
    String email = request.getParameter("email");
    
    Class.forName("com.mysql.jdbc.Driver");
    
   	Connection conn =null;
   	PreparedStatement pstmt =null;
   	try{
   	String jdbcDriver = "jdbc:mysql://localhost:3306/jsp_db?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
   	String dbUser = "jsp_db";
   	String dbPass = "jsp_db";
   	
   	String query = "insert into jsp_db.member values(?,?,?,?)";
   	
   	conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
   	pstmt = conn.prepareStatement(query);
   	
   	pstmt.setString(1,id);
   	pstmt.setString(2,pw);
   	pstmt.setString(3,name);
   	pstmt.setString(4,email);
   	
    pstmt.executeUpdate();
   	}catch(SQLException ex){}
   	finally{
   		if(pstmt!= null)try{pstmt.close();}catch(SQLException ex){}
   		if(conn!= null)try{conn.close();}catch(SQLException ex){}
   	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사압입</title>
</head>
<body>
MEMBER테이블에 새로운 레코드를 삽입하였습니다
<a href="/Ch14_Db/update/viewMemberList.jsp">확인</a>
</body>
</html>
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

    
    int updateCount =0;
    
    Class.forName("com.mysql.jdbc.Driver");
    
   	Connection conn =null;
   	PreparedStatement pstmt =null;
   	try{
   	String jdbcDriver = "jdbc:mysql://localhost:3306/jsp_db?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
   	String dbUser = "jsp_db";
   	String dbPass = "jsp_db";
   	
   	String query = "update jsp_db.member set name = ? where id= ?";
   	
   	conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
   	pstmt = conn.prepareStatement(query);
   	
   	pstmt.setString(1,name);
   	pstmt.setString(2,id);
   	
   	updateCount = pstmt.executeUpdate();
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
<title>Insert title here</title>
</head>
<body>
<%if(updateCount >0 ){ %>
<%=id %>의 이름을 <%=name %>으로 변경
<%}else{ %>
<%=id %> 아이디가 존재하지 않음
<%} %>
</body>
</html>
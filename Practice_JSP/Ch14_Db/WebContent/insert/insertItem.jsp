<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String idS = request.getParameter("id");

Connection conn = null;
PreparedStatement pstmtIt = null;
PreparedStatement pstmtDe = null;

String jdbcDriver = "jdbc:mysql://localhost:3306/jsp_db?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	String dbUser = "jsp_db";
	String dbPass = "jsp_db";

	Throwable occured = null;
	
	
	try{
		int id = Integer.parseInt(idS);
		
		conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
		conn.setAutoCommit(false);
		
		pstmtIt = conn.prepareStatement("insert into item values(?,?)");
		pstmtIt.setInt(1, id);
		pstmtIt.setString(2, "상품 이름 : "+id);
		pstmtIt.executeUpdate();
		
		if(request.getParameter("error")!=null){
			throw new Exception("의도적 익셉션 발생");
		}
		pstmtDe = conn.prepareStatement("insert into item_detail values(?,?)");
		pstmtDe.setInt(1, id);
		pstmtDe.setString(2, "상세 설명 : "+id);
		pstmtDe.executeUpdate();
		
		conn.commit();
		
	}catch(Throwable e){
		if (conn!=null){
			try{conn.rollback();
			
			}catch(SQLException ex){}
		}
		occured = e;
	}finally{
		if(pstmtIt != null)try{
			pstmtIt.close();
		}catch(SQLException ex){}
		if(pstmtDe != null)try{
			pstmtDe.close();
		}catch(SQLException ex){}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM 값 입력</title>
</head>
<body>
<%if (occured!=null){ %>
에러가 발생하였음. 
<%}else{ %>
데이터가 성공적으로 들어감
<%} %>
</body>
</html>
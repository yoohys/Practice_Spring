<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연결 테스트</title>
</head>
<body>
<%
	try(Connection conn=ConnectionProvider.getConnection()){
		out.println("successed to connect");
	}catch(SQLException ex){
		out.println("fail to connect connection: "+ex.getMessage());
		application.log("fail to connect connection");
	}
%>
</body>
</html>
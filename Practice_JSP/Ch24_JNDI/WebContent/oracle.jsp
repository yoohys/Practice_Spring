<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
 	Connection conn = null; 
	
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
  		conn = ds.getConnection();

//  		Tomcat8에섯 설정
//   		Context initContext = new InitialContext();
//   		Context envContext  = (Context)initContext.lookup("java:/comp/env");
//   		DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
//   		 conn = ds.getConnection();
  		
  		
  		
  		out.println("<h3>연결되었습니다.</h3>");
	}catch(Exception e){
		out.println("<h3>연결에 실패하였습니다.</h3>");
		e.printStackTrace();
 	}
%>
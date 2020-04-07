<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	//multipart/form-data인코딩을 이용한 데이터 출력하기
	InputStream is=null;

	out.print("[");
	out.print(request.getContentType());
	out.print("]");
	try{
		is = request.getInputStream();
		int data=-1;
		while((data=is.read())!=-1){
			out.print((char)data);
		}
	}finally{
		if(is!=null) try{is.close();}catch(IOException ex){}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application(JSP객체)::getRealPath()</title>
</head>
<body>
	<%
		String resourcePath = "/message/notice.txt";
	%>
	자원의 실제경로:
	<br>
	<hr>
	<%=application.getRealPath(resourcePath)%><br>
	<%
		char[] buff = new char[512];
		int len = -1; //문자를 쓸수없다(비어 있다.)
		BufferedReader br = null;
		try {
			InputStreamReader is = new InputStreamReader(application.getResourceAsStream(resourcePath), "UTF-8");
			br = new BufferedReader(is);

			while ((len = br.read(buff)) != -1) {
				out.print(new String(buff, 0, len));
			}
		} catch (IOException e) {
			out.println("Exception is occured: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}

		}
	%>
</body>
</html>
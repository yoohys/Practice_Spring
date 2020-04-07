<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application:JAVA</title>
</head>
<body>
	<%
		FileReader fr = null;
		char[] buff = new char[512];
		int len = -1; //문자를 쓸수없다(비어 있다.)
		try {
			fr = new FileReader("C:Space/JspServletSpace/Ch03.Jspbasic/WebContent/message/notice.txt");
			while ((len = fr.read(buff)) != -1) {
				out.print(new String(buff, 0, len));
			}
		} catch (IOException e) {
			out.println("Exception is occured: " + e.getMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}

		}
	%>
</body>
</html>
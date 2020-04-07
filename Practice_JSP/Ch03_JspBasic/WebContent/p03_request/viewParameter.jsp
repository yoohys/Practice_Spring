<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>request.getparameterMap()</b>
	<br>
	<%
		Map<String, String[]> map = request.getParameterMap();
		String[] name3 = map.get("name");

		String[] addr = map.get("address");
		String[] pet = map.get("pet");
	%>
	이름 :
	<%=name3[0]%><br> 주소 :
	<%=addr[0]%><br> 좋아하는 동물 :
	<%
		if (pet != null) {
			for (int i = 0; i < pet.length; i++) {
				out.println(pet[i]);

			}
		}
	%><br>
	<%
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String naming = (String) names.nextElement();
	%>
	<%=naming%>
	<%
		}
	%><br>
	<%
		Map map1 = request.getParameterMap();
		String[] maps = (String[]) map1.get("name");
		if (maps != null) {
	%>
	name=<%=maps[0]%>
	<%
		}
	%>
</body>
</html>
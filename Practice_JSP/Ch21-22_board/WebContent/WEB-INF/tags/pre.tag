<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
	value=value.replace("\n", "\n<br>");
	value=value.replace("&", "&amp;");
	value=value.replace("<", "&lt;");
	value=value.replace(",", "&nbsp;");
%>

<%=value%>

<!-- HTML은 <br>과 같은 태그를 사용하지 않으면 한줄로 표시함
줄바꿈과 문제 출력을 위해 치환하는 작업 -->
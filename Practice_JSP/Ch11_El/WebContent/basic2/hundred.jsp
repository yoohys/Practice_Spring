<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1~100</title>
</head>
<body>
<%int sum =0;
for(int i=1; i<=100; i++)
{sum += i;} 
request.setAttribute("result", new Integer(sum));
RequestDispatcher rd = request.getRequestDispatcher("hundredResult.jsp");
rd.forward(request, response);
%>


</body>
</html>
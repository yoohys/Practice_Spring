<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="1">
<tr><td>
<iframe src="left.jsp" width="350" height="400" onLoad="changeRight()"></iframe>
</td><td>
<iframe src = "right.jsp" width="450" height="400" id="right"></iframe>

</td></tr>
</table>
	<script>
		changeRight = function(){
			var rightFrame = document.getElementById("right");
			console.log("call!");
			rightFrame.src = "right.jsp";
		}
	</script>
</body>
</html>

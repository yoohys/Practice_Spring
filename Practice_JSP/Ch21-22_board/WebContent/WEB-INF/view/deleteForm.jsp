<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="delete.do" method="post">
<input type="hidden" value="${delReq.articleNumber}" name="no">
<input type="hidden" value="${delReq.title}" name="title">
<p>
	번호:<br/>${delReq.articleNumber}를 삭제하시겠습니까?
</p>
<input type="submit" value="글 삭제">
</form>
</body>
</html>
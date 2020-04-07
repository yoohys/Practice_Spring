<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<!-- WriteArticleHandler가 뷰로 사용하는 JSP -->
	게시글을 등록했습니다.
	<br>
	${ctxPath=pageContext.request.contextPath}
	<a href="${ctxPath}/article/list.do">[게시글 목록 보기]</a>
	<a href="${ctxPath}/article/read.do?no=${newArticleNo}">[게시글 내용 보기]</a>
<!-- 	WriteArticleHandler에서 전달한 newArticleNo속성을 게시글 번호로 사용 -->
</body>
</html>
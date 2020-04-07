<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="4"><a href="write.do">[게시글 쓰기]</a></td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:if test="${articlePage.hasNoArticles()}">
			<tr>
				<td colspan="4">게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="article" items="${articlePage.content}">
			<tr>
				<td>${article.number}</td>
					
					<!-- 게시글 읽기 링크 -->
				<td><a 
					href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
						<c:out value="${article.title}" />
				</a></td>
				<td>${article.writer.name}</td>
				<td>${article.readCount}</td>
			</tr>
		</c:forEach>
		<c:if test="${articlePage.hasArticles()}">
			<tr>		
				<td colspan="4">
				<c:if test="${articlePage.startPage>5}"><!-- 페이지 이동 링크의 시작번호가 5보다 클 때 이전으로 이동할 수 있는 링크  -->
						<a href="list.do?pageNo=${articlePage.startPage-5}">[이전]</a>
					</c:if> 
					<c:forEach var="pNo" begin="${articlePage.startPage}"
						end="${articlePage.endPage}">
						<a href="list.do?pageNo=${pNo}">[${pNo}]</a> <!-- 페이지 이동링크 -->
					</c:forEach> 
					<c:if test="${articlePage.endPage<articlePage.totalPages}">
		<a href="list.do?pageNo=${articlePage.startPage+5}">[다음]</a> <!-- 페이지 이동링크의 끝 번호가 마지막 페이지보다 작을 떄 다음으로 이동할 수있는 링크 -->
					</c:if></td>
			</tr>
		</c:if>
	</table>
</body>
</html>



















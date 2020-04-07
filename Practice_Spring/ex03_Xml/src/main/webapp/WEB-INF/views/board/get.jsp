<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name="bno"
						value='<c:out value="${board.bno}"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						value='<c:out value="${board.title}"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>Text atre</label>
					<textarea class="form-control" rows="3" name="content"
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>

				<!-- 나중에 다양한 상황을 처리하기 위해 form태그를 이용 -->
				<!-- <button data-oper='modify' class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button> --%>
				<!-- <button data-oper='list class="btn btn-info" onclick="location.href='/board/list'">List</button> -->
				<button data-oper='modify' class="btn btn-default">Modify</button>
				<button data-oper='list' class="btn btn-info">List</button>
				<form id='operForm' action="/board/modify" method="get">
					<input type="hidden" id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
					<!-- Pagination -->
					<input type="hidden" name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
					<input type="hidden" name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type="hidden" name='type' value='<c:out value="${cri.type}"/>'>
					<input type="hidden" name='keyword' value='<c:out value="${cri.keyword}"/>'>
				</form>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
		// form의 id(operForm)을 이요해 form 선택
		var operForm = $("#operForm");

		// modify button을 클릭하면 form > action 속성을 modify로 변경
		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/board/modify").submit();
		})
		// list button을 클릭하면 form > action 속성을 list로 변경
		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list?").submit();
		})
	});
</script>
<%@include file="../includes/footer.jsp"%>

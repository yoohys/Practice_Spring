<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables_Xml</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#No.</th>
							<th>Title</th>
							<th>Writer</th>
							<th>RegDate</th>
							<th>UpdateDate</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}" /></td>
							<td>
								<!-- 기존 창으로 열기 -->
								<!-- 새 창으로 열기: <a>tag에 target="_blank"속성 추가-->								 
								<!-- <a href='/board/get?bno=<c:out value="${board.bno}"/>'> -->
								<a class='move' href='<c:out value="${board.bno}"/>'>
									<c:out value="${board.title}" />
								</a>
							</td>
							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
						</tr>
					</c:forEach>
				</table>
				<!-- Search!! -->
				<div class='row'>
					<div class="col-lg-12">
						<form id="searchForm" action="/board/list" method="get">
							<select name='type'>
							<!-- 현재 page에 맞춰 type, keywod, pageNum, amount값 유지 -->
								<option value="" <c:out value="${pageMaker.cri.type == null? 'selected':'' }"/>>--</option>
								<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected':'' }"/>>제목</option>
								<option value="C" <c:out value="${pageMaker.cri.type eq 'C'? 'selected':'' }"/>>내용</option>
								<option value="W" <c:out value="${pageMaker.cri.type eq 'W'? 'selected':'' }"/>>작성자</option>
								<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'? 'selected':'' }"/>>제목 or 내용</option>
								<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'? 'selected':'' }"/>>제목 or 작성자</option>
								<option value="TWC" <c:out value="${pageMaker.cri.type eq 'TWC'? 'selected':'' }"/>>제목 or 내용 or 작성자</option>
							</select>
							<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>' />
							<input type="hidden" name="pageNum" value="<c:out value="${pageMaker.cri.pageNum}"/>">
							<input type="hidden" name="amount" value="<c:out value="${pageMaker.cri.amount}"/>">
							<button class='btn btn-default'>Search</button>
						</form>
					</div>
				</div>
				
				<!-- Pagination -->
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage - 1}">Previous</a>
							</li>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class='paginate_button ${pageMaker.cri.pageNum == num ? "active":""}'>
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
								<a href="${pageMaker.endPage + 1}">Next</a>
							</li>
						</c:if>
					</ul>
					<!-- <a> tag가 원래의 동작을 못하도록 설정 -> 해당 값을 들고 JS로 가서 처리 -->
					<form id='actionForm' action="/board/list" method="get">
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
						<input type="hidden" name="type" value="${pageMaker.cri.type}">
						<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
					</form>
					
					<!-- amount 변경버튼 -->
					<button class="amountBtn btn btn-xs pull-right" value=50>50</button>
					<button class="amountBtn btn btn-xs pull-right" value=20>20</button>
					<button class="amountBtn btn btn-xs pull-right" value=10>10</button>
					<div class="btn-xs pull-right">ListAmount</div>
				</div>
				<!-- end Pagination -->

				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-default">Save changes</button>
						</div>
					</div>
				</div>
				<!-- /.Modal -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(
			function() {
				// result가 발생하는 경우 (ex 새로 내용을 입력한 후) html창에 내용이 출력됨 
				var result = '<c:out value="${result}"/>'

				checkModal(result);

				// 뒤로가기 오류 해소 코드(생성>리스트>조회>리스트 진행시 param이 쌓여 생기는 오휴)
				history.replaceState({}, null, null);
				
				function checkModal(result) {
					// history.state가 true인 경우 (뒤로가기를 사용해서 온 경우) 수행 안함
					if (result == "" || history.state ) {
						return;
					}
					if (parseInt(result) > 0) {
						$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
					}

					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				})
				
				// Pagination
				// <a>tag의 동작 막기, <form><input>tag의 속성 바꾸기
				var actionForm = $("#actionForm");
				
				$(".paginate_button a").on("click", function(e){
					e.preventDefault();
					
					console.log('click');
					
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					// <a>tag 클릭시 submit() 수행시키기
					actionForm.submit();
				});
							
				// 게시물 조회를 위한 이멘트 처리 추가
				// get page에 다녀오면 list page가 1번으로 설정되는 오류 해결
				$(".move").on("click", function(e){
					e.preventDefault();
					actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr("href") + "'>");
					actionForm.attr("action", "/board/get");
					actionForm.submit();
				});
				
				$(".amountBtn").on("click", function(e){
					e.preventDefault();
					actionForm.find("input[name='amount']").val($(this).val());
					actionForm.submit();
				});

				// 검색버튼 이벤트 처리
				var searchForm = $("#searchForm");
				
				$("#searchForm button").on("click", function(e){
					if(!searchForm.find("option:selected").val()){
						alert("검색종류를 선택하세요");
						return false;
					}
					
					if(!searchForm.find("input[name='keyword']").val()){
						alert("키워드를 입력하세요");
						return false;
					}
					
					searchForm.find("input[name='pageNum']").val("1");
					e.preventDefault();
					
					searchForm.submit();
				});
			});
</script>

<%@include file="../includes/footer.jsp"%>

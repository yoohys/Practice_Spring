<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<!-- 목록페이지에서 링크를 통해 GET 방식으로 특정한 번호의 게시물을 조회할 수 있는 기능 작성
	게시물 번호를 보여줄 수 있는 필드를 추가하고 모든 데이터는 readonly를 지정해서 작성. 수정/삭제 버튼 추가 -->

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	$(document).ready(function() {

		var bnoValue = '<c:out value="${board.bno}"/>';
		var replyUL = $(".chat");
		showList(1);

		//댓글 페이지 호출
		function showList(page) {//페이지 번호를 파라미터로 받도록 설계하고, 만일 파라미터가 없는 경우에는 자동으로 1페이지가 설정되도록함.
		//브라우저에서 DOM처리가 끝나면 자동으로 showList()호출되어 <ul>태그 내에 내용으로 처리됨.
		//1페이지가 아닌 경우 기존 <ul>에 <li>들이 추가되는 형태
		console.log("show list "+page)
		replyService.getList({bno : bnoValue,page : page || 1},
							function(replyCnt,list) {
							console.log("replyCnt: "+replyCnt);
							console.log("list: "+list);
							console.log(list);
							
							if(page==-1){//마지막페이지 찾아서 호출
								pageNum=Math.ceil(replyCnt/10.0);
								showList(pageNum);
								return;
							}
							
			
								var str = "";
								if (list == null|| list.length == 0) {
									return;
								}
								for (var i = 0, len = list.length || 0; i < len; i++) {
									str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
									str += "<div><div class='header'><strong class='primary-font'>["
											+ list[i].rno+"] "+list[i].replyer+ "</strong>";
									str += "<small class='pull-right text-muted'>"
											+ replyService.displayTime(list[i].replyDate)
											+ "</small></div>";//시간순배열(해당일은 시분초, 전날은 년월일 )
									str += "<p>"+ list[i].reply+ "</p></div></li>";
									}
									replyUL.html(str);
									showReplyPage(replyCnt);
							});//end function

				}//end showList
				
				var modal=$(".modal");
				var modalInputReply = modal.find("input[name='reply']");
				var modalInputReplyer=modal.find("input[name='replyer']");
				var modalInputReplyDate=modal.find("input[name='replyDate']");
				
				var modalModBtn=$("#modalModBtn");
				var modalRemoveBtn=$("#modalRemoveBtn");
				var modalRegisterBtn=$("#modalRegisterBtn");
				
				$("#addReplyBtn").on("click", function(e){
					
					modal.find("input").val("");
					modalInputReplyDate.closest("div").hide();
					modal.find("button[id!='modalCloseBtn']").hide();
					modalRegisterBtn.show();
					$(".modal").modal("show");
				});
				
				modalRegisterBtn.on("click", function(e){
					var reply={
							reply:modalInputReply.val(),
							replyer:modalInputReplyer.val(),
							bno:bnoValue
					};
				
					replyService.add(reply, function(result){
						alert(result);
						
						modal.find("input").val("");
						modal.modal("hide");
						//showList(1);
						showList(-1);// 댓글 추가시 전체 댓글의 숫자를 파악하고 마지막페이지를 호출하여 댓글 확인
					});
				});
				
				
				
				//댓글 조회 클릭 이벤트 처리
				$(".chat").on("click","li", function(e){
					var rno=$(this).data("rno");
					replyService.get(rno, function(reply){
						modalInputReply.val(reply.reply);
						modalInputReplyer.val(reply.replyer);
						modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
						modal.data("rno",reply.rno);
						
						modal.find("button[id!='modalCloseBtn']").hide();
						modalModBtn.show();
						modalRemoveBtn.show();
						
						$(".modal").modal("show");
					});
					//console.log(rno);
				});

				modalModBtn.on("click",function(e){
					var reply={rno:modal.data("rno"),reply:modalInputReply.val()};
					replyService.update(reply,function(result){
						alert(result);
						modal.modal("hide");
						showList(pageNum);
					});
				});
				
				modalRemoveBtn.on("click",function(e){
					var rno=modal.data("rno");
					replyService.remove(rno,function(result){
						alert(result);
						modal.modal("hide");
						showList(pageNum);
					});
				});

				
				
				
				var pageNum=1;
				var replyPageFooter=$(".panel-footer");
				
				function showReplyPage(replyCnt){
					var endNum=Math.ceil(pageNum/10.0)*10;
					var startNum=endNum-9;
					
					var prev = startNum!=1;
					var next = false;
					
					if(endNum*10 >=replyCnt){
						endNum=Math.ceil(replyCnt/10.0);
					}
					
					if(endNum*10 <replyCnt){
						next=true;
					}
					
					var str="<ul class='pagination pull-right'>";
					
					if(prev){
						str+="<li class='page-item'><a class='page-link' href='"
								+(startNum-1)+"'>Previous</a></li>";
					}
					
					for(var i =startNum; i<=endNum; i++){
						var active = pageNum==i? "active":"";
						str+="<li class='page-item "+active+"'><a class='page-link' href='"
							+i+"'>"+i+"</a></li>";
					}
					
					if(next){
						str+="<li class='page-item'><a class='page-link' href='"
								+(endNum+1)+"'>Next</a></li>";
					}
					
					str+="</ul></div>";
					console.log(str);
					replyPageFooter.html(str);
				}
				//페이지의 번호를 클릭했을 때 새로운 댓글 가져오기 
				replyPageFooter.on("click","li a",function(e){
					e.preventDefault();
					console.log("page click");
					var targetPageNum=$(this).attr("href");
					console.log("targetPageNum:"+targetPageNum);
					pageNum=targetPageNum;
					showList(pageNum);
						//<a>태그의 기본동작을 제한(e.preventDefault())하고 댓글 페이지 번호를 변경한 후 해당페이지의 댓글 가져옴
					});
		});
</script>
<script>
	console.log("=====================");
	console.log("JS TEST");

	var bnoValue = '<c:out value="${board.bno}"/>';

	//for replyService add test
	replyService.add({
		reply : "JS TEST",
		replyer : "tester",
		bno : bnoValue
	}, function(result) {
		alert("RESULT: " + result);
	});

	//reply List Test
	replyService.getList({
		bno : bnoValue,
		page : 1
	}, function(list) {
		for (var i = 0, len = list.length || 0; i < len; i++) {
			console.log(list[i]);
		}
	});

	//13번 댓글 삭제 테스트 
	// 	replyService.remove(13, function(count) {
	// 		console.log(count);
	// 		if (count === "success") {
	// 			alert("REMOVED");
	// 		}
	// 	}, function(err) {
	// 		alert('ERROR...');
	// 	});

	//22번 댓글 수정
	replyService.update({
		rno : 22,
		bno : bnoValue,
		reply : "MODIFIED Reply...."
	}, function(result) {
		alert("수정 완료...");
	});

	//댓글 조회 처리 
	replyService.get(10, function(data) {
		console.log(data);
	});
</script>

<script type="text/javascript">
	//수정 버튼을 누른다면 bno값을 같이 전달하고 list로 이동하는 경우 bno태그를 지우고 리스트페이지로 이동.
	$(document).ready(function() {

		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/board/modify").submit();
		});
		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
	});
</script>

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
					<label>Text area</label>
					<textArea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${board.content}" />
				</textArea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>


				<button data-oper='modify' class="btn btn-default"
					onclick='location.href="/board/modify?bno=<c:out value='${board.bno}'/>"'>
					Modify</button>
				<button data-oper='list' class="btn btn-info"
					onclick="location.href='/board/list'">List</button>

				<form id="operForm" action="/board/modify" method="get">
					<input type="hidden" id="bno" name="bno"
						value="<c:out value='${board.bno }'/>"> <input
						type="hidden" name="pageNum"
						value='<c:out value="${cri.pageNum }"/>'> <input
						type="hidden" name="amount"
						value='<c:out value="${cri.amount }"/>'> <input
						type="hidden" name="keyword"
						value='<c:out value="${cri.keyword }"/>'> <input
						type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<!-- /.panel -->
		<div class="panel panel-default">
<!-- 			<div class="panel-heading"> -->
<!-- 				<i class="fa fa-comments fa-fw"></i>Reply -->
<!-- 			</div> -->
			<!-- /.panel-heading -->
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
					Reply</button>
			</div>

			<div class="panel-body">
				<ul class="chat">
					<!-- start reply -->
					<li class="left clearfix" data-rno="12">
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong> <small
									class="pull-right text-muted">2018-01-01 13:13</small>
							</div>
							<p>Good Job!</p>
						</div>
					</li>
					<!-- End reply -->
				</ul>
				<!-- End ul -->
			</div>
			<!-- /.panel .chat-panel -->
			<div class="panel-footer">
			
			
		</div>
	</div>
	<!-- ./End row -->
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label> <input class="form-control" name='reply'
						value='New Reply!!!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label> <input class="form-control" name='replyer'
						value="replyer">
				</div>
				<div class="form-group">
					<label>Reply Date</label> <input class="form-control" name='replyDate'
						value="">
				</div>

			</div>
			<div class="modal-footer">
				<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
				<button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
				<button id="modalRegisterBtn" type="button" class="btn btn-primary">Register</button>
				<button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@include file="../includes/footer.jsp"%>
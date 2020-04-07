<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<script>
	//새로고침을 통한 동일 내용 전송 차단 +뒤로가기할떄 모달창 다시 뜨는 것 방지
	$(document).ready(function() {
		
		(function(){//즉시실행 함수를 이용하여 첨부파일의 데이터를 가져오는 부분을 처리 <첨부파일 확인하는 부분>
			var bno="<c:out value='${board.bno}'/>";
			$.getJSON("/board/getAttachList", {bno:bno}, function(arr){
				console.log(arr);
				
				var str="";
				
				$(arr).each(function(i,attach){
					//image type
					if(attach.fileType){
						var fileCallPath= encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
						
						str+="<li ";
						str+="data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"
								+attach.fileName+"'data-type='"+attach.fileType+"'><div>";
						str+="<span>"+attach.fileName+"</span><br/>";
						str+="<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' ";
						str+="class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
							
						str+="<img src='/display?fileName="+fileCallPath+"'>";
						str+="</div></li>";				
					
					}else{
						str+="<li ";
						str+="data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"
								+attach.fileName+"'data-type='"+attach.fileType+"'><div>";
						str+="<span>"+attach.fileName+"</span><br/>";
						str+="<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' ";
						str+="class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
								
						str+="<img src='/resources/img/attach.png'>";
						str+="</div></li>";
						
					}
					
				});
				
				$(".uploadResult ul").html(str);
				
			}); //end getjson
		})();//end function
		
		//<화면에서 첨부파일을 삭제하는부분>
		$(".uploadResult").on("click","button",function(e){
			console.log("delete file");
			
			if(confirm("Remove thie file? ")){
				var targetLi=$(this).closest("li");
				targetLi.remove();//화면에서만 삭제처리
			}
		
		});
		
		
		var formObj = $("form");
		$('button').on("click", function(e) {
			e.preventDefault();
			var operation = $(this).data("oper");//data-oper 
			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list') {
				//move to list
				formObj.attr("action","/board/list").attr("method","get");
				var pageNumTag=$("input[name='pageNum']").clone();
				var amountTag=$("input[name='amount']").clone();
				var keywordTag=$("input[name='keyword']").clone();
				var typeTag=$("input[name='type']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
				
			}else if (operation==='modify'){
				
				console.log("submit clicked");
				
				var str="";
				
				$(".uploadResult ul li").each(function(i, obj){
					var jobj=$(obj);
					
					console.dir(jobj);
					str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
					str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
					str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
					str+="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
				
				});
				formObj.append(str).submit();
				
			}
			formObj.submit();
		});
		
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880;//5MB

		function checkExtension(fileName, fileSize) {

			if (fileSize >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}
			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;

		}
		
		$("input[type='file']").change(function(e){
			var formData=new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files=inputFile[0].files;
			for (var i = 0; i < files.length; i++) {
				
				if(!checkExtension(files[i].name,files[i].size)){//확장자와 파일크기 체크
					return false;
				}
				
				formData.append("uploadFile", files[i]);
			}

			$.ajax({
				url : '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData, //ajax를 통해 formData 자체를 전송
				type : 'POST',
				dataType:'json',
				success : function(result) {
					console.log(result);
					
					showUploadResult(result); //업로드 결과 처리 함수
				}

			}); //$.ajax

		});
	
		function showUploadResult(uploadResultArr){
			
			if(!uploadResultArr||uploadResultArr.length==0){return ;}
			
			var uploadUL=$(".uploadResult ul");
			
			var str="";
			
			
			$(uploadResultArr).each(
					function(i,obj){
				
				//image type check
				if(!obj.image){ //이미지가 아니면 첨부파일 이미지 붙이기 
					
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				
					var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");	
					//var regExp = /정규표현식/[Flag]; 
					//Flag g:global- 문자열의 모든 패턴을 찾음
					//Flag i:Ignore Case - 문자열의 대소문자구분x
					//Flag m:Multi line -문자열의 행이 바뀌어도 찾음		
					
					str+="<li ";
					str+="data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"
							+obj.fileName+"'data-type='"+obj.image+"'><div>";
					
					str+="<span>"+obj.fileName+"</span>";
					str+="<button type='button' data-file=\'"
							+fileCallPath+"\' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='/resources/img/attach.png'></a>";
					str+="</div></li>";
					
				}else{
					
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
						
					str+="<li ";
					str+="data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"
							+obj.fileName+"'data-type='"+obj.image+"'><div>";
					str+="<span>"+obj.fileName+"</span>";
					str+="<button type='button' data-file=\'"+fileCallPath+"\' ";
					str+="data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='/display?fileName="+fileCallPath+"'>";
					str+="</div></li>";
						
				}
			});
			uploadUL.append(str);
			
	}
	});
</script>
<!-- 목록페이지에서 링크를 통해 GET 방식으로 특정한 번호의 게시물을 조회할 수 있는 기능 작성
	게시물 번호를 보여줄 수 있는 필드를 추가하고 모든 데이터는 readonly를 지정해서 작성. 수정/삭제 버튼 추가 -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				
				<form role="form" action="/board/modify" method="post">
					<input type='hidden' name="pageNum" value="<c:out value='${cri.pageNum }'/>">
					<input type='hidden' name="amount" value="<c:out value='${cri.amount }'/>">
					<input type='hidden' name="type" value="<c:out value='${cri.type }'/>">
					<input type='hidden' name="keyword" value="<c:out value='${cri.keyword}'/>">
					
				
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title}"/>'>
					</div>

					<div class="form-group">
						<label>Text area</label>
						<textArea class="form-control" rows="3" name='content'><c:out
								value="${board.content}" />
				</textArea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>RegDate</label> <input class="form-control" name="regDate"
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>'
							readonly="readonly">
					</div>

					<div class="form-group">
						<label>Update Date</label> <input class="form-control"
							name="updateDate"
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>'
							readonly="readonly">
					</div>


					<button type="submit" data-oper='modify' class="btn btn-default">
						Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">
						Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">
						List</button>
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
		<div class="panel panel-default">
	
		<div class="panel-heading">Files</div>
		<!-- /.panel-heading -->
		<div class="panel-body">
			<div class="form-group uploadDiv">
				<input type="file" name="uploadFile" multiple>
			</div>
		<div class='uploadResult'>
			<ul>
			</ul>
		</div>
		</div>
		<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /. row -->


<style type="text/css">
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
	align-content: center;
	text-align:center;
}

.uploadResult ul li img {
	width: 100px;
}

.uploadResult ul li span{
	color:white;
}

.bigPictureWrapper{
	position:absolute;
	display: none;
	justify-content:center;
	align-items: center;
	top:0%;
	width:100%;
	height:100%;
	background-color: gray;
	z-index:100;
	background:rgba(255,255,255,0.5);
}

.bigPicture{
	position:relative;
	display:flex;
	justify-content: center;
	align-items: center;
}

.bigPicture img{
	width:600px;
}

</style>
<%@include file="../includes/footer.jsp"%>
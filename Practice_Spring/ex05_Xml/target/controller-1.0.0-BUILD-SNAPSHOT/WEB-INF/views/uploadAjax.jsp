<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<h1>Upload with Ajax</h1>
	<div class="uploadDiv">
		<input type='file' name='uploadFile' multiple>
	</div>

	<div class='uploadResult'>
		<ul>

		</ul>
	</div>

	<button id="uploadBtn">Upload</button>
	
	<div class="bigPictureWrapper">
		<div class='bigPicture'></div>
	</div>
	
	<!--  javaScript말고 JQuery로 처리하는 것이 편리함. -->

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script>

	function showImage(fileCallPath) {
		//alert(fileCallPath);
		$(".bigPictureWrapper").css("display","flex").show();
		
		$(".bigPicture").html("<img src='/display?fileName="+encodeURI(fileCallPath)+"'>")
						.animate({width:'100%', height:'100%'},1000);
		
	}
		$(document).ready(function() {
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
		 	
			//<input type='file'>객체가 포함된 <div>를 복사.
			var cloneObj=$(".uploadDiv").clone();
			
			$("#uploadBtn").on("click", function(e) {
				var formData = new FormData(); //Ajax에서 파일업로드는 FormData이용, 가상의 <form>과 같음.
				//Ajax를 이용하는 파일업로드는 FormData를 이용해서 필요한 파라미터를 담아서 전송하는 방식.
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				console.log("files : " + files);

				//add filedate to formdata
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
						
						showUploadedFile(result);
						//첨부파일 업로드 후 복사된 객체를 <div>에 다시 추가해서 첨부파일 부분 초기화하기
						$(".uploadDiv").html(cloneObj.html());
					}

				}); //$.ajax

			});

			var uploadResult=$(".uploadResult ul");
			
			$(".uploadResult").on("click","span",function(e){
				var targetFile=$(this).data("file");
				var type=$(this).data("type");
				console.log(targetFile);
				
				$.ajax({
					url:'/deleteFile',
					data:{fileName:targetFile, type:type},
					dataType:'text',
					type:'POST',
					success:function(result){
						alert(result);
					}			
				}); //$.ajax
			});
			
			function showUploadedFile(uploadResultArr){
				
				var str='';
				
				$(uploadResultArr).each(
						function(i,obj){
							
					if(!obj.image){ //이미지가 아니면 첨부파일 이미지 붙이기 
						
						var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					
						str+="<li><div><a href='/download?fileName="+fileCallPath+"'>"
								+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a>"
								+"<span data-file=\'"+fileCallPath+"\' data-type='file'>x</span>"
								+"<div></li>";
						}else{
							//str+="<li>"+obj.fileName+"</li>";
							var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
							
							var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
							
							originPath=originPath.replace(new RegExp(/\\/g),"/");
							
							//encodeURIComponent: URI호출에 적합한 문자열로 인코딩 처리하기(공백이나 한글이름문제 제거)
							str+="<li><a href=\"javascript:showImage(\'"+originPath+"\')\">"
								+"<img src='display?fileName="+fileCallPath+"'></a>"
								+"<span data-file=\'"+fileCallPath+"\' data-type='image'>x</span>"+"<li>";
						
						}
					});
				uploadResult.append(str);
			}
			
			$(".bigPictureWrapper").on("click", function(e){
				$(".bigPicture").animate({width:'0%', height:'0%'},1000);
				setTimeout(function(){
					$('.bigPictureWrapper').hide();
				},1000);
			});
		});
	</script>
</body>
</html>
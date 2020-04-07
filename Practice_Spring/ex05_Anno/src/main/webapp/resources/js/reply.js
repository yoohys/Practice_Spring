//reply.js:아무 기능 없이 간단히 동작하는 코드를 넣어 확인용도로 사용<게시물의 조회페이지에서 사용하기 위해 작성된 것>
console.log("Reply Module....");
//모듈구성하기
		//Javascript의 즉시 실행함수는 ()안에 함수를 선언하고 바깥쪽에서 실행함. 
	//즉시 실행함수는 함수으 ㅣ실행결과가 바깥쪽에 선언된 변수에 할당됨. =>ex)name이라는 변수에 AAAA라는 속성값을 가진 객체 할당.
var replyService=(function(){
	//JavaScript는 함수으 ㅣ파라미터 개수를 일치시킬 필요x, callback or error같은 파라미터는 필요에 따라서 작성가능.
	function add(reply, callback,error){//Ajax를 이용해 POST방식으로 호출하는 코드
		console.log("add reply............");
		//외부에서는 replyService.add(객체,콜백)를 전달하는 형태로 호출할 수 있는데 
		//Ajax호출은 감춰져 있기 때문에 코드를 좀 더 깔끔하게 작성가능 
		$.ajax({
			type:'post',
			url:'/replies/new',
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result, status,xhr){
				if(callback){
					callback(result);
				}
			},error: function(xhr, status,er){
				if(error){
					error(er);
				}
			}
		});
		
	}
	
	//jQuery의 getJSON()을 이용해서 처리
	//getList()는 param 이라는 객체를 통해 필요한 파라미터를 전달받아 JSON목록 호출(url호출 시 확장자를 '.json'으로 요구함)
	function getList(param, callback, error){
		var bno=param.bno;
		var page=param.page||1;
		$.getJSON("/replies/pages/"+bno+"/"+page+".json",
				function(data){
			if(callback){
				//callback(data);//댓글 목록만 가져오는 경우
				callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
	function remove(rno, callback, error){
		$.ajax({
			type:'delete',
			url:'/replies/'+rno,
			success:function(deleteResult, status,xhr){
				if(callback){
					callback(deleteResult);
				}
			},error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function update(reply, callback, error){
		console.log("RNO: "+reply.rno)
		$.ajax({
			type:'put',
			url:'/replies/'+reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result, status,xhr){
				if(callback){
					callback(result);
				}
			},error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function get(rno, callback, error){
		$.get("/replies/"+rno+".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
	////시간순배열(해당일은 시분초, 전날은 년월일 )
	function displayTime(timeValue){
		var today = new Date();
		var gap= today.getTime()-timeValue;
		var dateObj=new Date(timeValue);
		var str="";
		
		if(gap<(1000*60*60*24)){
			var hh= dateObj.getHours();
			var mi= dateObj.getMinutes();
			var ss=dateObj.getSeconds();
			
			return [(hh>9?'':'0')+hh,':',(mi>9?'':'0')+mi,':',(ss>9?'':'0')+ss].join('');
		}else{
			var yy=dateObj.getFullYear();
			var mm = dateObj.getMonth()+1; //getMonth() is zero-based
			var dd= dateObj.getDate();
			
			return [yy,'/', (mm>9?'':'0')+mm,'/',(dd>9?'':'0')+dd].join('');
		}
				
	};		
	
	
	return {add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime};//개발자 도구에서는 replyService객체의 내부에는 add라는 메서드가 존재하는 형태로 보임.
})();



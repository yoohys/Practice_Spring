package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController // @RestControler=@Controller+@ResponseBody
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	

	//등록작업과 테스트 : REST방식으로 처리할때는 데이터 포맷과 서버에서 보내주는 데이터 타입을 명확히 설계해야함
	//post방식. consumes와 produces를 이용해서 json방식의 데이터만 처리하고 문자열 반환
	@PostMapping(value="/new", 
			consumes = "application/json", 
			produces = {MediaType.TEXT_PLAIN_VALUE}) 
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		// @ResponseBody: 리턴 타입이 http의 응답메시지로 전송. 메소드나 파라미터로 사용
		//create(@RequestBody ReplyVO vo)로 JSON 데이터를 ReplyVO타입으로 변환 지정.
		log.info("ReplyVO: " + vo);
		int insertCount = service.register(vo);
		log.info("Reply INSERT COUNT: " + insertCount);
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		//create()는 내부적으로 ReplyServiceImpl을 호출해서 register()를 호출하고
		//	댓글이 추가된 숫자를 확인해서 브라우저에서 200 OK또는 500 Internet Server Error를 반환하도록 함.

		// 삼항 연산자 처리
	}
	
	//특정 게시물의 댓글 목록 확인
	@GetMapping(value="/pages/{bno}/{page}", 
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page")int page, @PathVariable("bno")Long bno){
		//@PathVariable : 중괄호에 명시된 값을 변수로 받는다
		
		Criteria cri = new Criteria(page,10);
		log.info("get Reply List bno: "+bno);
		log.info("cri: "+cri);
		//http://localhost:8080/replies/pages/99/1
		return new ResponseEntity<>(service.getListPage(cri, bno),HttpStatus.OK);			
	}

	//댓글 삭제/조회
	@GetMapping(value="/{rno}", 
				produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno")Long rno){
		log.info("get: "+rno);
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove: "+rno);
		return service.remove(rno)==1
				?new ResponseEntity<String>("success",HttpStatus.OK)
				:new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//댓글 수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		//@RequestBody:HTTP 요청의 body 부분을 그대로 변수에 넣는다. XML, JSON 일떄 이것을 주로 사용한다
		//@PathVariable : 중괄호에 명시된 값을 변수로 받는다
		vo.setRno(rno);
		log.info("rno: "+rno);
		log.info("modify: "+vo);
		return service.modify(vo)==1
				?new ResponseEntity<String>("success",HttpStatus.OK)
				:new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
























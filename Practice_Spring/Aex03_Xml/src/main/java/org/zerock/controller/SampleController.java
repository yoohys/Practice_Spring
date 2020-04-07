package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;
//@RestController = @Controller+@ResponseBody
@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")
	public String getText() {
		
		log.info("MIME TYPE:"+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
		
	}
	
	@GetMapping(value="/getSample",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
					    MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		
		return new SampleVO(112,"스타","로드");
	}

	@GetMapping(value = "/getSample2"/*
										 * , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
										 * MediaType.APPLICATION_XML_VALUE}
										 */)
	public SampleVO getSample2() {
		
		return new SampleVO(113,"스타2","로드2");
	}
	//list
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1, 10).mapToObj(i-> new SampleVO(i,i+"First", i+"Last")).collect(Collectors.toList());
		
	}
	
	//Map
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put(new String("First"), new SampleVO(111,"길동", "홍"));
		
		return map;
		
	}
	
	//ResponseEntity= data + HTTP Status Code
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo =  new SampleVO(000, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height<150) {
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result=ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
		
	}
	
	//@PathVariable= 경로+값
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, @PathVariable  Integer pid) {
		return new String[] {"category: "+cat, "productid: "+ pid};
		
	}
	//Post방식
	//@RequestBody:JSON데이터를 원하는 타입의 객체로 변환해야 하는 경우에 사용
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert:: ...ticket"+ticket);
		return ticket;
		
	}
	
	
}













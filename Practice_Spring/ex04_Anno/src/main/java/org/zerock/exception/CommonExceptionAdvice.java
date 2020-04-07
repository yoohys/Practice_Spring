package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;
//@ControllerAdvice : Controller(Servlet)+공통모듈 수행내용(AOP)/ 해당객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	//예외발생시 동작
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception......."+ex.getMessage());
		model.addAttribute("exception",ex); //구체적인 메시지를 보기 위해 Model을 이용해 전달
		log.error(model);
		//http://localhost:8080/sample/ex04?name=aaa&age=asd&page=9 age를 문자입력시 
		return "error_page";
	}
	
	//NotFound예외인 경우 수행
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {//fileNotFound
		//http://localhost:8080/asdf 입력시(/sample x)		
		return "custom404";
	}
}

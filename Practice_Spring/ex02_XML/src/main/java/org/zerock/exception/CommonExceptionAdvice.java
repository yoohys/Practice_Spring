package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// @ControllerAdvice: Controller + 공통 모듈 수행(AOP)
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class) // 예외 클래스 선언
	public String except(Exception ex, Model model) {

		log.info("Exception ------------------->" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.info(model);

		// '/sample/error_page'가 아니다 -> 별도의 클래스에 있기 때문에 기본경로를 찾아간다.
		return "errors/error_page"; // /views/errors/error_page.jsp
	}

	// 404Error: file not found
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 경로를 찾지 못할 경우 이놈이 작동한다
	public String handle404(NoHandlerFoundException ex) {
		return "errors/error_404"; // /views/errors/error_404.jsp
	}
}

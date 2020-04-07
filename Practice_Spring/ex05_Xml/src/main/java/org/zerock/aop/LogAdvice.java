package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //:해당 클래스의 객체가 Aspect를 구현함을 ㄴ타냄
@Log4j
@Component//:AOP와는 관계x , spring에서 Bean 으로 인식하기 위해 사용
public class LogAdvice {//로그를 기록해주는 클래스
	//@Before, @Around 뒤에있는 ("")는 pointcut
	
	//execution....은 AspectJ의 표현식임. execution의 경우 접근제한자와 특정클래스의 메서드를 지정가능.
	//*.....*.*(..)에서 맨 앞의 *는 접근제한자 뒤의 두개는 클래스의 이름과 메서드의 이름을 의미함.
	@Before("execution(* org.zerock.service.SampleService*.*(..))")//:BeforeAdvice를 구현한 메서드에 추가함.
	public void logBefore() {
		log.info("=================================");
			
	}
	//Advice와 관련된 어노테이션은 내부적으로 Pointcut를 지정함.
	
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String,String)) && args(str1,str2)")//:BeforeAdvice를 구현한 메서드에 추가함.
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1: "+str1);
		log.info("str2: "+str2);
			
	}
	
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
	//@AfterThrowing: 지정된 대상이 예외를 발생한 후에 동작하면서 문제를 찾을 수 있도록 도와줌.
	public void logException(Exception exception) {
		log.info("Exception....!!!");
		log.info("Exception: "+exception);
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	//@Around: 직접 대상 메서드를 실행할 수 있는 권한을 가지고, 메서드의 실행 전과 실행후에 처리 가능.
	public Object logTime(ProceedingJoinPoint pjp) {
		//ProceedingJoinPoint: @Around와 결합하여 파라미터나 예외등을 처리,AOP의 대상이 되는 Target이나 파라미터파악. 직접 실행 결정가능.
		long start = System.currentTimeMillis();
		
		log.info("Target: "+pjp.getTarget());
		log.info("Param: "+Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result=null;
		
		try {
			result=pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		log.info("TIME: "+(end-start));
		
		return result;//@Around일때는 return 타입이 void가 아니어야함.
	}
	
}

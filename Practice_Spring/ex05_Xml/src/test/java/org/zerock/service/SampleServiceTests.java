package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
//XML
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//JavaConfig
//@ContextConfiguration(classes= {org.zerock.config.RootConfig.class})
public class SampleServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Test
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception{
		log.info(service.doAdd("123", "456"));
		//LogAdivce의 설정이 같이 적용되어 아래와 같이 출력됨.
		//INFO : org.zerock.aop.LogAdvice - =================================
		//INFO : org.zerock.aop.LogAdvice - str1: 123
		//INFO : org.zerock.aop.LogAdvice - str2: 456
		//INFO : org.zerock.aop.LogAdvice - TIME: 5
		//INFO : org.zerock.service.SampleServiceTests - 579
		
		//실행결과 확인시 : @Around가 먼저 동작하고 @Before등이 실행된 후에 메서드가 실행되는데 걸린시간이 로그로 기록됨.
	
	}
	
//	@Test
//	public void testAddError() throws Exception{
//		log.info(service.doAdd("123", "abc"));
//		//INFO : org.zerock.aop.LogAdvice - Exception....!!!
//		//INFO : org.zerock.aop.LogAdvice - Exception: java.lang.NumberFormatException: For input string: "abc"
//	}
}

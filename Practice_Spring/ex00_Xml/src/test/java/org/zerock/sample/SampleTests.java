package org.zerock.sample;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//junit Test : 단위테스트
//Spring test 설정: spring-test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	//Restaurant Class를 setter()를 통한 주입
	@Setter(onMethod_ = @Autowired)
	private Restarunt restaurnt;
	
	@Test
	public void testExist() {
		assertNotNull(restaurnt);
		log.info(restaurnt);
		log.info("-----------------");
		log.info(restaurnt.getChef());
	}
}












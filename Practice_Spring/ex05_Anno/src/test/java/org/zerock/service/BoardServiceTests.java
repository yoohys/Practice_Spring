package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//XML
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//JavaConfig
//@ContextConfiguration(classes= {org.zerock.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new Text!!");
		board.setContent("new new content");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("new article number : "+board.getBno());
	}
	
	@Test
	public void testGetList() { //현재 테이블에 저장된모든 데이터 가져오기
		//service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(2,10)).forEach(board->log.info(board)); 
	}
	
	@Test
	public void testGet() {
		log.info(service.get(16L));
	}
	
	@Test
	public void testDelete() {
		//게시물 번호의 존재 여부를 확인하고 테스트하기
		log.info("REMOVE RESULT: "+service.remove(62L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(42L);
		if(board==null) {
			return;
		}
		
		board.setTitle("modify the title");
		log.info("MODIFY RESULT: "+service.modify(board));
	}
}

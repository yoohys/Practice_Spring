package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;
//
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}

	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new article 1");
		board.setContent("new content1");
		board.setWriter("newbie");

		service.register(board);

		log.info("new article No.: " + board.getBno());
	}

//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info(board));
//	}

//	@Test
//	public void testGet() {
//		log.info(service.get(2L));
//	}

//	@Test
//	public void testDelete() {
//		log.info("REMOVE RESULT: " + service.remove(7L));
//	}

//	@Test
//	public void testUpdate() {
//		BoardVO board = service.get(2L);
//		if (board == null) {
//			return;
//		}
//		board.setTitle("new title");
//		log.info("MODIFY RESULT: " + service.modify(board));
//	}

}

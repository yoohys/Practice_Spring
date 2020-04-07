package org.zerock.controller;
// Spring의 Test기능 활용 (WAS 사용 대신)

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// Test for Controller
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
// java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class, org.zerock.config.ServletConfig.class})
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	// 가짜mvc 생성: 가짜로 URL과 파라미터 등을 브라우저에서 사용하는 것처럼 만든다 > Controller Test
	private MockMvc mockMvc;

	// 모든 Test 전에 실행
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}

//	@Test
//	public void testList() throws Exception {
//		// MockMvcRequestBuilders: Get방식 호출
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap());
//		// 'localhost:8080/board/list' 수행 -> Controller에서 /board/ 검색
//		// -> BoardController에서 /list/ 검색 -> list()에 있는 코드 수행
//		// -> 함수 속 service.getList() 수행 -> 콘솔로 결과 출력
//	}
//	
//	@Test
//	public void testRegister() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "new test title1")
//				.param("content", "new test content1")
//				.param("writer", "user00")
//				).andReturn().getModelAndView().getViewName();
//		// post방식 + parameter 전달
//
//		log.info(resultPage);
//	}
//	
//	@Test
//	public void testGet() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//				.param("bno", "21"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap());
//	}
//	
//	@Test
//	public void testModify() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("bno", "21")
//				.param("title", "new test title2")
//				.param("content", "new test content2")
//				.param("writer", "user00")
//				).andReturn().getModelAndView().getViewName();
//
//		log.info(resultPage);
//	}
//	
//	@Test
//	public void testRemove() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//				.param("bno", "22")).andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//	}
}

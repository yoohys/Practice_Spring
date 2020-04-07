package org.zerock.controller;

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
//Test for Controller
@WebAppConfiguration // :Servlet의 servletcontext, WebApplicationContext를 이용하기 위함
//XML방식
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
//Java config
//@ContextConfiguration(classes = {org.zerock.config.RootConfig.class,org.zerock.config.ServletConfig.class})
@Log4j
public class BoardControllerTests {
	// 웹 개발시 매번 URL 테스트 하기 위해 TOMCAT과 같은 was를 실행하는 불편한 단계 생략 하기 위해 다른 코드로 진행

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc; // MockMvc:가짜 mvc

	@Before // @Before가 적용된 메서드는 모든 테스트 전에 매번 실행하는 메서드가 됨
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		// MockMvcRequestBuilders를 이용해 Get방식의 호출을하고 반환된 결과를 이용해 데이터 확인
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testListPaging() throws Exception {
		// MockMvcRequestBuilders를 이용해 Get방식의 호출을하고 반환된 결과를 이용해 데이터 확인
		log.info(
				mockMvc
				.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum","2")
				.param("amount","50"))
				.andReturn().getModelAndView().getModelMap()
				);
	}

	@Test
	public void testRegister() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register").param("title", "test new title")
						.param("content", "test new content").param("writer", "user0000"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))//mockmvc를 이용해서 파라미터를 전달시 문자열로만 처리해야함
				.andReturn()
				.getModelAndView().getModelMap());
		
	}
	
	@Test
	public void testModify() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "12")//mockmvc를 이용해서 파라미터를 전달시 문자열로만 처리해야함
						.param("title", "new modified test title")
						.param("content", "new modified test content")
						.param("writer", "user486"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}
	
	@Test
	public void testRemove() throws Exception {
		//삭제전 데이터베이스 게시물 번호 확인
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "61")) //mockmvc를 이용해서 파라미터를 전달시 문자열로만 처리해야함
				.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
}

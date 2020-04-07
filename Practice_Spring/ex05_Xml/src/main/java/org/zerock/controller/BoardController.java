package org.zerock.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.pageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor // 생성자를 만들지 않은 경우 @setter 사용
public class BoardController { // 전체 목록을 가져오는 처리
	private BoardService service;// @AllArgsConstructor로 생성자만들기

//	@GetMapping("/list")
//	public void list(Model model) {// 후에 게시물의 목록을 전달해야하므로 Model을 파라미터로 지정
//		log.info("list");
//		model.addAttribute("list", service.getList());
//
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri,Model model) {// 후에 게시물의 목록을 전달해야하므로 Model을 파라미터로 지정
		log.info("list: "+cri);
		model.addAttribute("list", service.getList(cri));
		//model.addAttribute("pageMaker", new pageDTO(cri, 123));
		
		int total = service.getTotal(cri);
		log.info("total: "+total);
		model.addAttribute("pageMaker", new pageDTO(cri, total));
		
	}

	@PostMapping("/register") //등록처리
	public String register(BoardVO board, RedirectAttributes rttr) {
		// 등록 작업이 끝난 후 다시 목록화면으로 이동
		// RedirectAttributes를 사용하여 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달
		log.info("============================================");
		log.info("register : " + board);
		if(board.getAttachList()!=null) {
			board.getAttachList().forEach(attach->log.info(attach));
		}
		log.info("============================================");
		
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
		// "redirect:"접두어를 이용하여 SPRING MVC가 내부적으로 response.sendRedirect()처리
	}
	
	@GetMapping("/register")
	public void register() {
		
	}

	@GetMapping({"/get", "/modify"}) //조회처리
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri,Model model) {
		// 후에 게시물의 목록을 전달해야하므로 Model을 파라미터로 지정 // criteria도 파라미터로 추가해서 받고 전달.
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));

	}
	
	@PostMapping("/modify") 
	//수정작업을 시작하는 화면의 경우에는 GET방식으로 접근하지만 실작업은 POST방식으로 동작
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		// 등록 작업이 끝난 후 다시 목록화면으로 이동
		log.info("modify : " + board);

		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		//방법1
		//수정삭제 처리는 BoardController에서 redirect 방식으로 동작하므로 type과 keyword조건을 리다이렉트 시에 포함시켜야함
		//redirect는 get방식으로 이루어지기 때문.
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());		
//		rttr.addAttribute("type",cri.getType());		
//		rttr.addAttribute("keyword",cri.getKeyword());		
//
//		return "redirect:/board/list";
		
		//방법2
		return "redirect:/board/list"+cri.getListLink();
		// "redirect:"접두어를 이용하여 SPRING MVC가 내부적으로 response.sendRedirect()처리
	}
	
	@PostMapping("/remove") 
	//삭제작업은 반드시 POST방식으로만 처리
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
		log.info("remove..."+bno);
		
		//삭제 전 먼저 해당 게시물의 첨부파일 목록 확보.
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if(service.remove(bno)) {
			
			//delete Attach Files
			deleteFiles(attachList);//게시물과 첨부파일 데이터 삭제
			
			rttr.addFlashAttribute("result","success");
		}
		
		//방법 1
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());
//		rttr.addAttribute("type",cri.getType());		
//		rttr.addAttribute("keyword",cri.getKeyword());		
//		
//		return "redirect:/board/list";
		
		//방법2
		return "redirect:/board/list"+cri.getListLink();
		// "redirect:"접두어를 이용하여 SPRING MVC가 내부적으로 response.sendRedirect()처리
	}

		
		
		
	
	
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody //BoardController는 @RestController로 작성되지 않았기때문에 직접 @ResponseBody를 적용하여 JSON데이터 반환처리
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		log.info("getAttachList "+bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		if(attachList==null||attachList.size()==0) {
			return;
		}
		
		log.info("delete attach files...................");
		log.info(attachList);
		
		attachList.forEach(attach->{
			try {
				Path file = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()
										+"_"+attach.getFileName());
				
				Files.deleteIfExists(file);
				//첨부파일 데이터 삭제 후 실제파일 삭제 시도.
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_"
									+attach.getUuid()+"_"+attach.getFileName());
					Files.delete(thumbNail);
				}
				
				
				
			}catch(Exception e) {
				log.error("delete file error"+e.getMessage());
			}
		});
	}
	
	
	
}

package com.practice.board.controller;

import com.practice.board.dto.BoardDto;
import com.practice.board.service.BoardService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "/")
// 컨트롤러임을 명시하는 어노테이션
@AllArgsConstructor
// Bean 주입방식과 관련이 있으며 Bean객체를 받는방식을 해결해줌
public class BoardController {
    private BoardService boardService;

    //  게시글 페이지
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail.html";
    }

    //  게시글 수정 페이지
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update.html";
    }

    //  게시글 수정 작업
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }

    //  게시글 삭제 작업
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }

    //  게시글 리스트 페이지
    @GetMapping("/")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) throws NotFoundException {
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);

        return "board/list.html";
    }

    //  게시글 리스트 데이터
    @GetMapping("/data")
    @ResponseBody
//  JSON데이터를 생성하기 위해 들어감
    public Map<String,List<BoardDto>> listData()  {
        Map<String, List<BoardDto>> map = new HashMap<String, List<BoardDto>>();
        List<BoardDto> boardL = boardService.getBoardlist();
        map.put("data",boardL);

       return map;
    }

    //  게시글 작성 페이지
    @GetMapping("/post")
    public String write() {
        System.out.println(11);
        return "board/write.html";

    }

    //  게시글 작성 작업
    @PostMapping(value = "/post2")
    public String write2(@ModelAttribute BoardDto boardDto) {
        System.out.println("2");
        boardService.savePost(boardDto);
        System.out.println("3");
        return "redirect:/";
    }

    //  게시글 검색 작업
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }




}

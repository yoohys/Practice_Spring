package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno>0") //BoardMapper.xml 에 처리함

	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board); //nextval 조회
	
	public BoardVO read(Long bno); //insert가 된 작업 조회작업
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri); //게시물 목록과 전체 데이터수 구하기
	
	
	//해당 게시물의 번호인 bno와 증가나 감소를 의미하는amount변수에 파라미터를 받음 
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}

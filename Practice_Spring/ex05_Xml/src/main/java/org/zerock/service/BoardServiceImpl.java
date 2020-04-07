package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	//spring 4.3 이상에서 자동 처리 : Mapper들 주입
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;
	
	@Transactional//tbl_board테이블과 tbl_attach 테이블 양쪽 모두 insert가 진행되어야함.
	@Override
	public void register(BoardVO board) {
		log.info("register......."+board);
		
		//tbl_table에 먼저 게시물을 등록하고 각 첨부파일은 생성된 게시물 번호를 세팅한 후 tbl_attach 테이블에 데이터를 추가함.
		mapper.insertSelectKey(board);//currval, nextval 처리/ MyBatis의 selectkey를 이용함.
		
		if(board.getAttachList()==null||board.getAttachList().size()<=0) {
			return;
		}
		
		board.getAttachList().forEach(attach->{
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..............."+bno);
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify.........."+board);
		
		attachMapper.deleteAll(board.getBno()); //기존 첨부파일 삭제
		
		boolean modifyResult = mapper.update(board)==1;
		
		if(modifyResult&&board.getAttachList()!=null&&board.getAttachList().size()>0) {
			board.getAttachList().forEach(attach->{
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
	}

	@Transactional //첨부파일과 실제 게시물의 삭제가 같이 처리되도록함
	@Override
	public boolean remove(Long bno) {
		log.info("remove..........bno: "+bno);
		
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList..............");
//		return mapper.getList();
//	}
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria: "+cri);
		return mapper.getListWithPaging(cri);
	}
	
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override //첨부파일목록 가져오기 
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno: "+bno);
		return attachMapper.findByBno(bno);
	}
	
	

}

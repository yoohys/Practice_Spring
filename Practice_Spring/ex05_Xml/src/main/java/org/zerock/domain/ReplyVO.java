package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private Long rno;
	private Long bno;//해당댓글이 어느글의 댓글인지를 ㅁ명시
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	
}

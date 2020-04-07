package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	//검색조건처리 목적
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	public String[] getTypeArr() {//검색조건이 각 글자(T,W,C)로 구성되어 있으므로 검색조건을 배열로 만들어서 한번에 처리하기 위함.
		
		return type==null? new String[] {}:type.split("");
	}
	
	public String getListLink() {
		//웹페이지에서 매번 파이미터를 유지하는 일이 귀찮을때 + javascript를 사용할 수 없는 상황에서 링크처리시 사용
		//org.springframework.web.util.UriComponentsBuilder : 여러개의 파라미터들을 연결해서 URL의 형태로 만듦
		//URL을 만들어주면 리다이렉트를 하거나, <form>태그를 사용하는 상황을 많이 줄여줄수있음.
		//검색조건을 유지하는 org.zerock.domain.Criteria 클래스에 링크생성기능 추가
		UriComponentsBuilder builder= UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}

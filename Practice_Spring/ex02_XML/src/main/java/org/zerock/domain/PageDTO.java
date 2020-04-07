package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	// Paging 관련 연산 모두 수행
	// Paging: [prev | 11 | 12 | 13 | ... | 19 | 20 | next]
	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {

		this.total = total;
		this.cri = cri;

		// endPage: paging에 표현할 마지막 페이지
		// startPage: paging에 표현할 첫 페이지
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// prev, next 표현 여부
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}

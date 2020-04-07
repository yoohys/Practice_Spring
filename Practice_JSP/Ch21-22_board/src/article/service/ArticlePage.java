package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage { //게시글 목록을 제공하는 서비스클래스
	private int total;//전체게시글의 개수
	private int currentPage;//사용자가 요청한 페이지 번호보관
	private List<Article> content;//
	private int totalPages;//전체 페이지 개수 보관
	private int startPage; //화면하단에 보여줄 페이지 이동링크의 시작번호
	private int endPage;//화면하단에 보여줄 페이지 이동링크의 끝 번호 
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		//size:한 페이지에 보여줄 게시글 개수 
		this.total=total;
		this.currentPage=currentPage;
		this.content=content;
		if(total==0) {//게시글 개수가 0개인 경우 모두 모든 페이지 수를 0으로 할당한다
			totalPages=0;
			startPage=0;
			endPage=0;
		}else {//게시글 개수를 이용하여 전체 페이지 개수 구하기 
			totalPages=total/size; //페이지 개수
			if(total%size>0) {//나머지가 0보다 크면 페이지수 1증가
				totalPages++;
			}
			//화면 하단에 보여줄 페이지 이동링크의 시작페이지 번호 구하기(5개 페이지씩 이동링크 출력가정)
			int modVal=currentPage%5;
			startPage=currentPage/5*5+1;
			if(modVal==0) startPage-=5;
			
			endPage=startPage+4;
			if(endPage>totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}
	
	public boolean hasNoArticles() {
		return total==0;
	}
	public boolean hasArticles() {
		return total>0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Article> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}

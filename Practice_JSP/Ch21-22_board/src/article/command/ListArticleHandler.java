package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {//웹 요청 처리

	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal=req.getParameter("pageNo");//pageNo 파라미터 값을 이용해서 읽어올 페이지 번호 구하기
		int pageNo=1;
		if(pageNoVal!=null) {
			pageNo=Integer.parseInt(pageNoVal);
		}
		//ListArticleHandler를 이용해서 지정한 페이지 번호에 해당하는 게시글 데이터 구하기
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/listArticle.jsp";
		
	}

}

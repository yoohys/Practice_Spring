package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler{

	private ReadArticleService readService = new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int articleNum=Integer.parseInt(noVal);
		
		try {//readService.getArticle()메서드는 지정한 번호에 해당하는 게시글 데이터가 존재하지 않으면 익셉션 발생
			ArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);//articleData에 데이터 저장
			return "/WEB-INF/view/readArticle.jsp";
		}catch(ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article",e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}
	
}

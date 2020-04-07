package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			//article 테이블에서 지정한 번호의 Article객체 구하기 
			Article article = articleDao.selectById(conn, articleNum);
			if (article == null) {//게시글 데이터 존재x
				throw new ArticleNotFoundException();
			}
			//article_content 테이블에서 지정한 번호의 ArticleContent 객체 구하기
			ArticleContent content = contentDao.selectById(conn, articleNum);
			if (content == null) {//게시글 내용 데이터 존재x
				throw new ArticleContentNotFoundException();
			}
			if (increaseReadCount) {//increaseReadCount가 true이면 조회수 증가
				articleDao.increaseReadCount(conn, articleNum);
			}
			return new ArticleData(article, content);//ArticleData 객체 리턴 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

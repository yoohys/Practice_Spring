package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size=10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int total=articleDao.selectCount(conn);//전체 게시글 개수 구하기
			//PageNum에 해당하는 게시글 목록 구하기 
			//articleDao.select() 메서드의 두번쨰 파라미터는 조회할 레코드의 시작행.
			//시작행은 0번을 기준으로 하므로 (pageNum-1)*size를 시작행번호로 사용
			List<Article> content = articleDao.select(conn, (pageNum-1)*size, size);
			return new ArticlePage(total, pageNum, size, content); //ArticlePage 객체 리턴 
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

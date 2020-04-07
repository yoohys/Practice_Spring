package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyArticleService {
	private ArticleDao articleDao= new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void modify(ModifyRequest modReq) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//게시글 번호에 해당하는 Article 객체를 구하고 게시글이 존재하지 않으면 익셉션 발생 
			Article article = articleDao.selectById(conn, modReq.getArticleNumber());
			if(article==null) {
				throw new ArticleNotFoundException();
			}
			if(!canModify(modReq.getUserId(), article)) {//수정가능검사
				throw new PermissionDeniedException();
			}
			
			//두 DAO의 update()메서드를 이용해 제목과 내용을 수정.
			articleDao.update(conn, modReq.getArticleNumber(), modReq.getTitle());
			contentDao.update(conn, modReq.getArticleNumber(), modReq.getContent());
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
			
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
			
		}finally {
			JdbcUtil.close(conn);
		}
	}
	//수정하려는 사용자 ID가 게시글 작성자ID와 동일하면 true리턴 
	private boolean canModify(String modifyingUserId, Article article) {
		return article.getWriter().getId().equals(modifyingUserId);
	}
}

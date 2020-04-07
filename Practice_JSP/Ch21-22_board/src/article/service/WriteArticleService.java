package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.management.RuntimeErrorException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {//게시글 쓰기 기능 
	private ArticleDao articleDao=new ArticleDao();
	private ArticleContentDao contentDao=new ArticleContentDao();
	
	public Integer write(WriteRequest req) {//writeRequest타입의 req 파라미터를이용한 게시글 등록 및 결과로 게시글번호 리턴
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작 
			
			Article article = toArticle(req);//article 객체 생성.
			
			//ArticleDao의 insert()메서드를 실행하고 그 결과를 savedArticle에 할당. 
			//데이터 삽입의 경우 savedArticle은 null이 아니고 article테이블에 추가한 데이터의 주요 키값을 number값으로 갖는다.
			Article savedArticle = articleDao.insert(conn, article);
			if(savedArticle==null) {//테이블의 레코드 x
				throw new RuntimeException("fail to insert article");
			}
			
			//30행에서 삽입한 데이터와 동일한 번호를 값으로 갖는 ArticleContent 객체 생성 
			ArticleContent content= new ArticleContent(savedArticle.getNumber(), req.getContent());
			ArticleContent savedContent= contentDao.insert(conn, content);//article_content테이블에 데이터 삽입
			if(savedContent==null) {
				throw new RuntimeException("fail to insert article_content");	
			}
			conn.commit();
			return savedArticle.getNumber();//새로 추가한 게시글 번호 리턴 
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	private Article toArticle(WriteRequest req) {//insert 쿼리를 실행해야 id를 알 수 있으므로 number값에 null전달
		Date now = new Date();
		return new Article(null, req.getWriter(), req.getTitle(), now,now,0);
	}
}

package article.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;

public class ArticleDao {//article 테이블 데이터 삽입
	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {//insert 쿼리를 실행해서 article 테이블에 데이터 삽입. article_no 칼럼은 자동 증가칼럼이므로 Insert 쿼리 실행시 값지정x
			pstmt = conn.prepareStatement("insert into article values(article_no_seq.nextval,?,?,?,?,?,0)");
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				//last_insert_id(): 가장 최근에 insert 된 row의 auto increment column의 값을 반환
				rs = stmt.executeQuery("select article_no_seq.currval from article"); //article 테이블에 새롭게 추가한 행의 article_no값 구하기
				if (rs.next()) {
					Integer newNum = rs.getInt(1);//신규게시글 번호 구하기 
					return new Article(newNum, article.getWriter(), article.getTitle(), article.getRegDate(),
							article.getModifiedDate(), 0); //article 테이블에 추가한 데이터를 담은 Article객체 리턴 
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}

	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	public int selectCount(Connection conn)throws SQLException{//article 테이블의 전체레코드 수 리턴
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select count(*) from article");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Article> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try {//limit을 사용해 쿼리실행결과 중 일부 레코드만 조회시 사용(첫번쨰 행번호와 읽어올 레코드 개수)
			//행번호는 0번 기준, 역순정렬 
			pstmt=conn.prepareStatement("select * from article where rownum >=? and rownum<=?"
							+"order by article_no desc ");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs=pstmt.executeQuery();
			List<Article> result=new ArrayList<>();
			while(rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);			
		}
	
	}

	private Article convertArticle(ResultSet rs) throws SQLException{
		return new Article(rs.getInt("article_no"), 
				new Writer(rs.getString("writer_id"), 
						rs.getString("writer_name")), 
				rs.getString("title"),  
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
		
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Article selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement("select * from article where article_no=?");
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			Article article = null;
			if(rs.next()) {
				article=convertArticle(rs);
			}
			return article;			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	public void increaseReadCount(Connection conn, int no)throws SQLException{
		try(PreparedStatement pstmt=conn.prepareStatement("update article set read_cnt=read_cnt+1 where article_no=?")){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException{
		try(PreparedStatement pstmt= conn.prepareStatement(
				"update article set title=?, moddate=SYSDATE "+
						"where article_no=?")){
			pstmt.setString(1, title);
			pstmt.setInt(2,no);
			return pstmt.executeUpdate();
		}

	}
	public int delete(Connection conn, int no) throws SQLException{
		try(PreparedStatement pstmt= conn.prepareStatement(
				"delete from article where article_no=?")){
			pstmt.setInt(1,no);
			return pstmt.executeUpdate();
		}
		
	}
}

















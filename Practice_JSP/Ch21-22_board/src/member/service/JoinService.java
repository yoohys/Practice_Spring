package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {//회원가입기능구현 
	private MemberDao memberDao=new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn=null;
		try {//DB커넥션을 구하고 트랜잭션 시작
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//회원데이터구하기
			Member member=memberDao.selectById(conn, joinReq.getId());
			
			//가입하려는 ID에 해당하는 데이터가 이미 존재하면, 트랜잭션을 롤백하고 DuplicatedIdException발생
			if(member!=null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			//joinReq를 이용해서 Member객체를 생성하고, MemberDao의 Insert()로 회원데이터를 테이블에 삽입
			memberDao.insert(conn, new Member(
									joinReq.getId(),
									joinReq.getName(),
									joinReq.getPassword(),
									new Date()));
			conn.commit(); //트랜잭션 커밋
		}catch(SQLException e) {//처리도중 SQLException이 발생하면 트랜잭션 롤백 후 runtimeExceiption발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);//커넥션 종료 
		}
	}
}

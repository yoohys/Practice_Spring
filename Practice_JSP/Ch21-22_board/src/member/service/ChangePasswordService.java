package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();
	
	//암호변경기능 구현 변경할 회원아이디, 현재 암호, 변경할 암호로 구성됨
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId); //userId에 해당하는 Member데이터구하기
			if(member==null) {
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(curPwd)) { //현재 암호와 일치여부검사
				throw new InvalidPasswordException();
			}
			member.changePassword(newPwd); //member 객체의 암호데이터 변경
			memberDao.update(conn, member); //변경한 암호 데이터를 DB테이블에 반영
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		}
}

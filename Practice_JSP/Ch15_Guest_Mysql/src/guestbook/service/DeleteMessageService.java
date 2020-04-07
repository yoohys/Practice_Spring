package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	private static DeleteMessageService instance = new DeleteMessageService();

	public static DeleteMessageService getInstance() {
		return instance;
	}

	private DeleteMessageService() {

	}

	public void deleteMessage(int messageId, String password) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false); ///트랜잭션을 시작한다
			
			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if(message ==null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if(!message.matchPassword(password)) {
				throw new InvalidPaswordException("bad password");
			}
			messageDao.delete(conn, messageId);
			conn.commit();
			
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패 : "+ex.getMessage(),ex);
			
		}catch(InvalidPaswordException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	
	
}

package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//커맨드 패턴 기반의 코드 : 복잡함 줄이고 하나으 ㅣ명령어를 하나으 ㅣ클래스에서 처리하도록 구현하는 패턴.
public interface CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	//1.명령어와 관련된 비즈니스 로직 처리
	//2. 뷰 페이지에서 사용할 정보 저장
	//3. 뷰 페이지의 URI 리턴
}

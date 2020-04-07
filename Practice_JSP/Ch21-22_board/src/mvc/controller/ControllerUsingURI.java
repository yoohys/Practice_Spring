package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.*;

public class ControllerUsingURI extends HttpServlet {
	
private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	public void init() throws ServletException{//설정파일로부터 매핑정보를 읽어와 Properties 객체에 저장
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties(); //Properties:(이름,값)목록을 갖는 클래스 :프로퍼티 이름을 커맨드이름/값을 클래스이름으로 저장
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)) { 
			prop.load(fis);
		}catch(IOException e) {
			throw new ServletException(e);
		}
		
		Iterator keyIter = prop.keySet().iterator(); 
		while(keyIter.hasNext()) {
			String command=(String) keyIter.next(); //프로퍼티 이름을 커맨드 이름으로 사용
			String handlerClassName=prop.getProperty(command); //커맨드 이름에 해당하는 핸들러 클래스이름은 Properties에서 구하기
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);//핸들러 클래스 이름을 이용해서 Class객체 구하기
				//Class로부터 핸들러 객체를 생성
				CommandHandler handlerInstance=(CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance); //commandHandlerMap에 (커맨드, 핸들러 객체)매핑정보를 저장
			}catch(ClassNotFoundException|InstantiationException|IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String command=request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0) {
			command=command.substring(request.getContextPath().length());
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler==null) {
			handler=new NullHandler(); //404에러를 응답으로 전송하는 핸들러 클래스 
		}
		String viewPage=null;
		try {
			//구한 핸들러 객체의 process()메서드를 호출해서 요청을 처리하고, 결과로 보여줄 뷰 페이지 경로를 리턴값으로 전달받기. 
			//핸들러 인스턴스인 handler의 process()메서드는 클라이언트의 요청을 알맞게 처리한 후, 뷰 페이지에 보여줄 결과값을 request나 session의 속성에 저장
			viewPage=handler.process(request, response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		if(viewPage!=null) { //viewPage가 null이 아닐 경우, 핸들러 인스턴스가 리턴한 뷰페이지로 이동.
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
























	
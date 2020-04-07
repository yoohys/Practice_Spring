package postconstruct_predestroy;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/postpre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PostPreServlet() {
       System.out.println("생성자");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	
	public void destroy() {
		System.out.println("destroy()");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("postConstruct");
	}
	
	@PreDestroy
	public void clean() {
		System.out.println("PreDestroy");
	}

}












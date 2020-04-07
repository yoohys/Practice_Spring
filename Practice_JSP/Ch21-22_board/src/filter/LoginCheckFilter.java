package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter { //로그인 여부 검사 

	@Override
	public void destroy() {

	}

	@Override //authUser 속성으로 로그인 여부를 검사하고 없으면 login.do로 리다이렉트 
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("authUser")==null) {
			HttpServletResponse response=(HttpServletResponse) res;
			response.sendRedirect(request.getContextPath()+"/login.do");
		}else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

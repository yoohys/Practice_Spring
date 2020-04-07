package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
//xml방식:root-context
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//xml방식에서 web.xml을 대신 :WebConfig
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	//한글 설정
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter c = new CharacterEncodingFilter();
		c.setEncoding("utf-8");
		c.setForceEncoding(true);
				
		return new Filter[] {c};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
		//MultipartConfig설정 추가 파일 업로드사이즈 크기 설정.
		MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\temp",20971520,41943040,20971520);
		registration.setMultipartConfig(multipartConfig);
		
	}
	
}

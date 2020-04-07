package org.zerock.config;

import java.io.IOException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//WebMvcConfigurer:spring5.0 mvc 설정시 사용
//                  depricate: WebMvcConfigurerAdapter
@EnableWebMvc
@ComponentScan(basePackages= {"org.zerock.controller","org.zerock.service"})
public class ServletConfig implements WebMvcConfigurer{

	//자동완성 안되면, ctrl+space
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
	}
	
	
	
//	public CommonsMultipartResolver getResolver() throws IOException {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setMaxUploadSize(1024*1024*10);//10MB
//		resolver.setMaxUploadSizePerFile(1024*1024*2);
//		resolver.setMaxInMemorySize(1024*1024);
//		resolver.setUploadTempDir(new FileSystemResource("C:\\upload\\tmp"));
//		resolver.setDefaultEncoding("utf-8");
//		
//		return resolver;
//		
//	}
	
}







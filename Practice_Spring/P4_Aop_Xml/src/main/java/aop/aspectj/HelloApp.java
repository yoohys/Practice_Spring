package aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext factory 
		= new FileSystemXmlApplicationContext("classpath:beans_aspectj.xml");
		MessageBean bean = (MessageBean) factory.getBean("messageBean");
		bean.sayHello();
		
		
		((AbstractApplicationContext) factory).close();

	}

}

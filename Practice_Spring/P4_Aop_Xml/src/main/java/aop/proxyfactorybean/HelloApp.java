package aop.proxyfactorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext factory 
		= new FileSystemXmlApplicationContext("classpath:beans.xml");
		MessageBean bean = (MessageBean) factory.getBean("proxy");
		bean.sayHello();
		
		
		((AbstractApplicationContext) factory).close();

	}

}

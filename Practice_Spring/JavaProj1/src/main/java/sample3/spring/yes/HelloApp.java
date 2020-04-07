package sample3.spring.yes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory("src/main/java/sample3/spring/yes");
		ApplicationContext factory = 
		new ClassPathXmlApplicationContext("beans.xml");
		MessageBean bean = factory.getBean("messageBean",MessageBean.class);
		bean.sayHello("hong");
	}
}

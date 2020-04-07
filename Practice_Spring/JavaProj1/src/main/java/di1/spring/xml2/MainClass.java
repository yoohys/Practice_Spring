package di1.spring.xml2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	
	ApplicationContext ap = new ClassPathXmlApplicationContext("applicationCTX2.xml");
	MyInfo mi = ap.getBean("myinfo",MyInfo.class);
	mi.getInfo();

	((AbstractApplicationContext) ap).close();
	
}
}

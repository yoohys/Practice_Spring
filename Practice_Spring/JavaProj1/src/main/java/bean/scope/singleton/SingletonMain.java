package bean.scope.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//Ioc Contationer : Singleton 객체생성(객체를 한번만 생성)
public class SingletonMain {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:singleton.xml");
		SingletonTest st1 = (SingletonTest) context.getBean("singletonTest");
		SingletonTest st2 = (SingletonTest) context.getBean("singletonTest");
		SingletonTest st3 = (SingletonTest) context.getBean("singletonTest");

		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		((AbstractApplicationContext) context).close();
	}
}

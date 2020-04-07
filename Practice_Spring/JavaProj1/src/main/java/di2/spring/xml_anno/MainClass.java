package di2.spring.xml_anno;
//XML 주인과 Annotation 종속 구조

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		String s = "classpath:xml_anno.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(s);
		
		Student st1 = ctx.getBean("student1",Student.class);
		System.out.println("이름 : "+st1.getName());
		System.out.println("나이 : "+st1.getAge());
		System.out.println("취미 : "+st1.getHobbys());
		System.out.println("키 : "+st1.getHeight());
		System.out.println("몸무게 : "+st1.getWeight());
		System.out.println("===============================");
		Student st2 = ctx.getBean("student2",Student.class);
		System.out.println("이름 : "+st2.getName());
		System.out.println("나이 : "+st2.getAge());
		System.out.println("취미 : "+st2.getHobbys());
		System.out.println("키 : "+st2.getHeight());
		System.out.println("몸무게 : "+st2.getWeight());
		


	ctx.close();
	
	}
}

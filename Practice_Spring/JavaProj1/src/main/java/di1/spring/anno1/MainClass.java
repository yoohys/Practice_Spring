package di1.spring.anno1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	Student s = ctx.getBean("student",Student.class);
	System.out.println("이름 : "+s.getName());
	System.out.println("나이 : "+s.getAge());
	System.out.println("취미 : "+s.getHobbys());
	System.out.println("키 : "+s.getHeight());
	System.out.println("몸무게 : "+s.getWeight());
	
	ctx.close();
	
	}
}

package di1.spring.xml4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	
	AbstractApplicationContext apc = new GenericXmlApplicationContext("construct_ctx.xml");
	StudentInfo s1 = apc.getBean("studentInfo1",StudentInfo.class);
	StudentInfo s2 = apc.getBean("studentInfo2",StudentInfo.class);
	s1.getStudentInfo();
	s2.getStudentInfo();
	apc.close();
	
	
}
}

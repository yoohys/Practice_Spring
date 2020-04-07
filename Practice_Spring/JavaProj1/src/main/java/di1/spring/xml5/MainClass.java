package di1.spring.xml5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di1.spring.xml4.StudentInfo;

public class MainClass {
public static void main(String[] args) {
	
	AbstractApplicationContext apc = new GenericXmlApplicationContext("applicationCTX3.xml","construct_ctx.xml");
	Family f = apc.getBean("family",Family.class);
	System.out.println(f.papaName);
	System.out.println(f.mamaName);
	System.out.println(f.brotherName);
	System.out.println(f.sisterName);
	
	System.out.println("=================");
	StudentInfo s=  apc.getBean("studentInfo1",StudentInfo.class);
	s.getStudentInfo();
	
	apc.close();
	
	
}
}

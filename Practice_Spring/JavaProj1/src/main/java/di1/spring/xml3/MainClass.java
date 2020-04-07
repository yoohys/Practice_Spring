package di1.spring.xml3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("pencil.xml");
		Pencil6BWithEraser p6b =  ctx.getBean("pencil6Bwe",Pencil6BWithEraser.class);
		Pencil4B p4 =  ctx.getBean("pencil4B",Pencil4B.class);
		Pencil6B p6 =  ctx.getBean("pencil6B",Pencil6B.class);
		p6b.use();
		p4.use();
		p6.use();
		
		ctx.close();
		
	}
}

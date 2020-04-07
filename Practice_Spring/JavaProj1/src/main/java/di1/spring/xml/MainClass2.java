package di1.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applcationCTX1.xml");
//		MyCalculator mc =ctx.getBean("mycalculator",MyCalculator.class); // 둘다 가능
		MyCalculator mc =(MyCalculator) ctx.getBean("mycalculator"); // 둘다 가능
		
//		MyCalculator mc = new MyCalculator();
//		mc.setC(new Calculator());
//		mc.setFirstName(1);
//		mc.setSecondName(3);
		mc.add();
		mc.sub();
		mc.mul();
		mc.div();
		ctx.close();
					
		
		

	}

}

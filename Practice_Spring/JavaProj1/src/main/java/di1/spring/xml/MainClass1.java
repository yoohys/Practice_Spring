package di1.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass1 {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationCTX1.xml");
		MyCalculator mc = factory.getBean("mycalculator" ,MyCalculator.class);
//		MyCalculator mc = new MyCalculator();
//		mc.setC(new Calculator());
//		mc.setFirstName(1);
//		mc.setSecondName(3);
		mc.add();
		mc.sub();
		mc.mul();
		mc.div();
		((AbstractApplicationContext) factory).close();
					
		
		

	}

}

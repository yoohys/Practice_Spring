package di2.spring.anno_xml;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//Annotation방식, 클래스객체 생성

@Configuration
@ImportResource("classpath:anno_xml.xml")
public class ApplicationConfig {

//	<bean id="calculator" class="di1.spring.xml.Calculator" ></bean>
//	<bean id="mycalculator" class="di1.spring.xml.MyCalculator" >
//	<property name="c">
//	<ref bean="calculator"/>
//	</property>
//	<property name="firstName" value="10"></property>
//	<property name="secondName" value="2"></property>
//	</bean>

	@Bean
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
	
		Student s = new Student("홍길동", 20, hobbys);
		s.setHeight(200);
		s.setWeight(50);
		
		
		return s;
		
	}
}

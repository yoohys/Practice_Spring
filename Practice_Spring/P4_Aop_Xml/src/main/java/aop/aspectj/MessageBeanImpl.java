package aop.aspectj;

import org.springframework.util.StopWatch;

//핵심 관심사항
public class MessageBeanImpl implements MessageBean {

	private String name;
	

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


  
	
	 // 공통관심 사항이 적용될 메소드
	@Override
	public void sayHello() {
				
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello, "+name+"!");
	}

}















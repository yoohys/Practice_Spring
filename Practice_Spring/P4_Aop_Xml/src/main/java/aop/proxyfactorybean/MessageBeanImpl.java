package aop.proxyfactorybean;

import org.springframework.util.StopWatch;

//핵심 관심사항
public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


  
	public String getGreeting() {
		return greeting;
	}



	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	 // 공통관심 사항이 적용될 메소드
	@Override
	public void sayHello() {
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("method start");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(greeting+" : "+name);
		sw.stop();
		System.out.println("method stop");
		System.out.println(sw.getTotalTimeMillis()/1000+ "초");
		System.out.println(sw.prettyPrint());
	}

}















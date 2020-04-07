package sample2.inteface;

public class MessageBeanKr implements MessageBean {

	@Override
	public void sayHello(String s) {
		System.out.println("안녕하세요 "+s+"!");

	}

}

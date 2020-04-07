package sample2.inteface;

public class HelloApp {
public static void main(String[] args) {
	MessageBeanEn be = new MessageBeanEn();
			MessageBeanKr bk = new MessageBeanKr();
			
			be.sayHello("John");
			bk.sayHello("김");
	
}
}

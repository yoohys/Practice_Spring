package bean.scope.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//scope=prototype: 컨테이너에서 객체생성정보 요청될 때마다 객체생성
//scope=request: 요청이 있을 때 마다 객체생성
//scope=session: 세션이 있을 때 마다
public class ProtoMain {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:prototype.xml");
		ProtoTest pt1 = (ProtoTest) context.getBean("protoTest");
		ProtoTest pt2 = (ProtoTest) context.getBean("protoTest");
		ProtoTest pt3 = (ProtoTest) context.getBean("protoTest");

		System.out.println(pt1);
		System.out.println(pt2);
		System.out.println(pt3);
		((AbstractApplicationContext) context).close();
	}
}

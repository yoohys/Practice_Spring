package aop.proxyfactorybean;
//Aop 방법 2가지: Spring AOP 사용
//              AspectJ
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
//횡단관심사항
public class LoggingAdvice implements MethodInterceptor {
//MethodInvocation: Joinpoint
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("start");
		Object rtnObj =  invocation.proceed();//적용
		sw.stop();
		System.out.println(sw.getTotalTimeSeconds()/1000+"초");
		return rtnObj;
	}

}

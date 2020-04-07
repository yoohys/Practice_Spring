package aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//AspectJ를 사용한 공통관심사항 
//@Around(execution(* sayHello())")
public class LoggingSample {
	//Around Advice에 수행될 공통관심사항
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		String methodName= pjp.getKind();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("[LOG] METHOD: "+ methodName+" is calling");
		Object rtnObj = pjp.proceed();
		sw.stop();
		System.out.println("[LOG] METHOD: "+ methodName+" was called");
		System.out.println("[LOG] 처리시간: "+ sw.getTotalTimeMillis()/1000+" 초");
		return rtnObj;
		
	}
}

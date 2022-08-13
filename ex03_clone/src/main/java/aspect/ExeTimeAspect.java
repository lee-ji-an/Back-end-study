package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {

	// 공통 기능(Aspect)을 적용할 대상을 설정(@Pointcut 애노테이션에 execution 속성)
	// ex05 패키지와 그 하위 패키지에 위치한 public 메서드를 Pointcut으로 설정
	@Pointcut("execution(public * ex05..*(..))")
	private void publicTarget() {
		
	}
	
	// Around Advice 를 설정
	// publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용
	// measure => 사용자 정의 메서드 ==> 공통 기능을 구현
	// ProceedingJoinPoint ==> 프록시 대상 객체의 메서드를 호출할 때 사용
	@Around("publicTarget()")  //Pointcut 지정, publicTarget()에 적용할 것이다
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			// 실제 대상 객체의 메서드
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 = %dns\n", 
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),
					Arrays.toString(joinPoint.getArgs()),
					(end-start)
			);
		}
	}
}

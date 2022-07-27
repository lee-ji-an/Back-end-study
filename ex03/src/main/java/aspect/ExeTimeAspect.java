package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect {
	// ���� ����� ������ ����� ���� 
	// ex05 ��Ű���� �� ���� ��Ű���� ��ġ�� public �޼��带 Pointcut���� ����
	@Pointcut("execution(public * ex05..*(..))")
	private void publicTarget() {
		
	}
	
	// Around Advice�� ����
	// publicTarget() �޼��忡 ������ Pointcut�� ���� ����� ���� 
	// measure => ����� ���� �޼��� ==> ���� ����� ����
	// ProceedingJoinPoint ==> ���Ͻ� ��� ��ü�� �޼��带 ȣ���� �� ��� 
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			// ���� ��� ��ü�� �޼��� 
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) ����ð� = %dns\n", 
				joinPoint.getTarget().getClass().getSimpleName(), 
				sig.getName(), 
				Arrays.toString(joinPoint.getArgs()), 
				(end - start)
			);
		}
	}	
}

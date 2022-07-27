package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class CacheAspect {

	private Map<Long, Object> cache = new HashMap();
	
	@Pointcut("excution(public * ex05..*(long))*")
	public void cacheTarget() {
		
	}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		long num = (Long)joinPoint.getArgs()[0];
		if (cache.containsKey(num)) {
			System.out.printf("CacheAspect: cache���� ������ [ %d ]\n", num);
			return cache.get(num);
		}
		Object result = joinPoint.proceed(); //�� factorial ����� ����
		cache.put(num, result);
		System.out.printf("CacheAspect: cache�� �߰� [ %d ]\n", num);
		return result;
		
	}
}

package boardClone.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

	@Pointcut("execution(* boardClone..controller.*Controller.*(..)) || execution(* boardClone..service.*Impl.*(..)) || execution(* boardClone..mapper.*Mapper.*(..))")
	private void loggerTarget() { }
	
	@Around("loggerTarget()")
	public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		if (name.indexOf("Controller") > -1) {
			type = "[Controller] ";
		} else if (name.indexOf("ServiceImpl") > -1) {
			type = "[ServiceImpl] ";
		} else if (name.indexOf("Mapper") > -1) {
			type = "[Mapper] ";
		}
		log.debug(type + name + "." + joinPoint.getSignature().getName());
		return joinPoint.proceed();
	}
}

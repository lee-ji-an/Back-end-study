package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import ex05.Calculator;
import ex05.RecCalculator;

@Configuration		//여기서만 new, 아까와 다른 점
//@ComponentScan(basePackages = { "ex03", "ex04" })	//ex04 패키지도 스캔 대상으로 추가
//@AspectJ 어노테이션을 붙인 클래스를 공통 기능으로 적용
//스프링은 @AspectJ 어노테이션이 붙은 빈 객체를 찾아서 빈 객체의 @Pointcut 설정과 @Around 설정을 사용

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
	
	
	
}

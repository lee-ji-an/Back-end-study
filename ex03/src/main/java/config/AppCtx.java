package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import ex05.Calculator;
import ex05.RecCalculator;

@Configuration		//���⼭�� new, �Ʊ�� �ٸ� ��
//@ComponentScan(basePackages = { "ex03", "ex04" })	//ex04 ��Ű���� ��ĵ ������� �߰�
//@AspectJ ������̼��� ���� Ŭ������ ���� ������� ����
//�������� @AspectJ ������̼��� ���� �� ��ü�� ã�Ƽ� �� ��ü�� @Pointcut ������ @Around ������ ���

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

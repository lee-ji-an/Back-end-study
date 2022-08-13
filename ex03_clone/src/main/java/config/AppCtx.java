package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import aspect.ExeTimeAspect;
import ex03_clone.MemberPrinter;
import ex03_clone.MemberSummaryPrinter;
import ex03_clone.VersionPrinter;
import ex04.Client;
import ex04.Client2;
import ex05.Calculator;
import ex05.RecCalculator;

@Configuration
@ComponentScan(basePackages = { "ex03_clone" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}

	
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype")
	public Client2 client2() {
		Client2 c = new Client2();
		c.setHost("www.myhost.com");
		return c;
	}
	
//	@Bean
//	public Client client() {
//		Client c = new Client();
//		c.setHost("www.myhost.com");
//		return c;
//	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(1);
		return versionPrinter;
	}
	

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
//	@Bean
//	public MemberListPrinter memberListPrinter() {
//		return new MemberListPrinter(memberDao(), memberPrinter());
//	}
	
//	@Bean
//	public MemberInfoPrinter memberInfoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		//infoPrinter.setMemberDao(memberDao());
//		//infoPrinter.setPrinter(memberPrinter2());
//		return infoPrinter;
//	}
}

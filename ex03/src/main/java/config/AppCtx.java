package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ex03.MemberDao;
import ex03.MemberPrinter;
import ex03.MemberSummaryPrinter;
import ex03.VersionPrinter;
import ex04.Client;
import ex04.Client2;

@Configuration		//여기서만 new, 아까와 다른 점
@ComponentScan(basePackages = { "ex03", "ex04" })	//ex04 패키지도 스캔 대상으로 추가
public class AppCtx {
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype")
	public Client2 client2() {
		Client2 c = new Client2();
		c.setHost("www.myhost.com");
		return c;
	}
	
	@Bean
	public Client client() {
		Client c = new Client();
		c.setHost("www.myhost.com");
		return c;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	@Qualifier("printer")	
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(1);
		return versionPrinter;
	}

	
}

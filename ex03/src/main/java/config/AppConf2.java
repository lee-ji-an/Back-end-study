package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex03.ChangePasswordService;
import ex03.MemberDao;
import ex03.MemberInfoPrinter;
import ex03.MemberListPrinter;
import ex03.MemberPrinter;
import ex03.MemberRegisterService;
import ex03.VersionPrinter;

@Configuration
public class AppConf2 {
	@Autowired	//여기서도 쓸 수 있게 넣어줌 -> 갖다 쓸 수 있음
	private MemberDao memberDao;
	@Autowired	//스프링 빈에 의존하는 다른 빈을 자동으로 주입하고 싶을 때 사용
	private MemberPrinter memberPrinter;	//AppConf1 클래스에서 설정한 빈이 할당

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDao);	// ⇐ 설정 메서드에서는 필드를 사용해서 필요한 빈을 주입

	}
	
	@Bean 
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		//infoPrinter.setMemberDao(memberDao);	-> MemberInfoPrinter 에서 Autowired해서 set필요 x
		//infoPrinter.setPrinter(memberPrinter);
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(1);
		return versionPrinter;
	}
}

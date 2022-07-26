package assembler;

import ex03.ChangePasswordService;
import ex03.MemberDao;
import ex03.MemberRegisterService;

public class Assembler {		//객체 조립기, 객체를 생성하고 의존 객체를 주입하는 기능을 제공하는 클래스
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao);  //의존 주입
		this.pwdSvc = new ChangePasswordService();
	}

	public MemberDao getMemberDao() {
		return this.memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return this.regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return this.pwdSvc;
	}
}

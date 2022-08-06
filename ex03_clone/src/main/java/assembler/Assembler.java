package assembler;

import ex03_clone.ChangePasswordService;
import ex03_clone.MemberDao;
import ex03_clone.MemberRegisterService;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao);
		this.pwdSvc = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
	
}

package assembler;

import ex03.ChangePasswordService;
import ex03.MemberDao;
import ex03.MemberRegisterService;

public class Assembler {		//��ü ������, ��ü�� �����ϰ� ���� ��ü�� �����ϴ� ����� �����ϴ� Ŭ����
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDao = new MemberDao();
		this.regSvc = new MemberRegisterService(memberDao);  //���� ����
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

package ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {
	
	private MemberDao memberDao;
	//�� ���� ������ü�� �ʿ�
	private MemberPrinter printer;
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}

	

package ex03_clone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")	//public MemberInfoPrinter infoPrinter() { return new MemberInfoPrinter(); }
public class MemberInfoPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 데이터가 없습니다.");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}

package ex03_clone;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	@Qualifier("printer")
	private MemberPrinter printer;
	
//	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
//		this.memberDao = memberDao;
//		this.printer = printer;
//	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(member->printer.print(member));
	}
}

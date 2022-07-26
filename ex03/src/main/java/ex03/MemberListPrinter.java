package ex03;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(member -> printer.print(member));  
		//하나씩 출력하는 거는 만들어놨으니 그걸 써서 모두 출력
	}
}

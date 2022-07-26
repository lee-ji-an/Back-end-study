package ex03;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {	//����� �� ���� ���� ����Ʈ
	
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� mm�� dd��");
	}
	public void print(Member member) {
		
		if (dateTimeFormatter == null) {
			System.out.printf("ȸ�� ���� : ���̵�=%s, �̸���=%s, �̸�=%s, �����=%tF\n", 
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("ȸ�� ���� : ���̵�=%s, �̸���=%s, �̸�=%s, �����=%s\n", 
				member.getId(), member.getEmail(), member.getName(), 
				dateTimeFormatter.format(member.getRegisterDateTime()));
		}
		
	}
}

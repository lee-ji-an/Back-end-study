package ex03;

public class MemberSummaryPrinter extends MemberPrinter{

	public void print(Member member) {
		System.out.printf("ȸ�� ���� : �̸���=%s, �̸�=%s\n", 
				member.getEmail(), member.getName());
	}
}

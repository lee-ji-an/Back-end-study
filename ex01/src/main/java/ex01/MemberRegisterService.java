package ex01;

public class MemberRegisterService {
	
	private MemberDAO dao = new MemberDAO();	//->MemberDAO�ٲ�� ��� ��������?
	// ���⼭ new�� ���� ���� �ٸ� ���� new �ؼ� �����ڸ� ���� �޴� ����� �� good
	//ȸ�� ������ DB�� ���� ó���ϴ� ����
	//������ ȸ�� ������ �ִ� ��� ���ܸ� �߻��ϰ�,
	//�׷��� ���� ��� Ȯ�� �� ȸ�� ������ ����
	
	public void regist(Member member) throws Exception {
		Member m = dao.selectByEmail(member.getEmail());
		if (m != null) {
			throw new Exception("�̸����� �ߺ��Ǿ����ϴ�.");
		}
		dao.insert(member);
	}
}

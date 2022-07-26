package ex03;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;

//	public ChangePasswordService(MemberDao memberDao) { -> ���� ������ ���� �ڵ�� ���ʿ�
//		this.memberDao = memberDao;
//	}
	
	public void changePassword(String email, String oldpw, String newpw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new RuntimeException("��ϵ� ȸ���� �����ϴ�.");
		}
		member.changePassword(oldpw, newpw);
		memberDao.update(member);
	}
}

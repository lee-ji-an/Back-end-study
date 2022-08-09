package ex03_clone;

import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new RuntimeException("등록된 회원이 없습니다.");
		}
		member.changePassword(oldPw, newPw);
	}
}

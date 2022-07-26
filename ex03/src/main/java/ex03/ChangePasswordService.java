package ex03;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;

//	public ChangePasswordService(MemberDao memberDao) { -> 의존 주입을 위한 코드는 불필요
//		this.memberDao = memberDao;
//	}
	
	public void changePassword(String email, String oldpw, String newpw) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new RuntimeException("등록된 회원이 없습니다.");
		}
		member.changePassword(oldpw, newpw);
		memberDao.update(member);
	}
}

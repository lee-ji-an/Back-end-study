package ex03;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복" + (req.getEmail()));
		}
		// 사용자 입력값을 내부 처리에 사용할 값으로 변경
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
				);
		memberDao.insert(newMember);
		return newMember.getId();
	}
	
}

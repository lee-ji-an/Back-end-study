package ex01;

public class MemberRegisterService {
	
	private MemberDAO dao = new MemberDAO();	//->MemberDAO바뀌면 어떻게 유지보수?
	// 여기서 new를 하지 말고 다른 데서 new 해서 생성자를 통햇 받는 방식이 더 good
	//회원 정보를 DB에 저장 처리하는 서비스
	//동일한 회원 정보가 있는 경우 예외를 발생하고,
	//그렇지 않은 경우 확인 후 회원 정보를 저장
	
	public void regist(Member member) throws Exception {
		Member m = dao.selectByEmail(member.getEmail());
		if (m != null) {
			throw new Exception("이메일이 중복되었습니다.");
		}
		dao.insert(member);
	}
}

package ex03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	//회원 아이디
	private static long nextId = 0;
	
	//회원 정보를 담고 있는 맵
	//키: 이메일, 값: 회원 정보
	private Map<String, Member> map = new HashMap();
	
	//이메일에 해당하는 멤버 정보를 조회해서 변환
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// 멤버 정보를 업데이트
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	//모든 멤버 정보 반환
	public Collection<Member> selectAll(){
		return map.values();
	}
}

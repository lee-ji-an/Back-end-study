package ex03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	//ȸ�� ���̵�
	private static long nextId = 0;
	
	//ȸ�� ������ ��� �ִ� ��
	//Ű: �̸���, ��: ȸ�� ����
	private Map<String, Member> map = new HashMap();
	
	//�̸��Ͽ� �ش��ϴ� ��� ������ ��ȸ�ؼ� ��ȯ
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// ��� ������ ������Ʈ
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	//��� ��� ���� ��ȯ
	public Collection<Member> selectAll(){
		return map.values();
	}
}

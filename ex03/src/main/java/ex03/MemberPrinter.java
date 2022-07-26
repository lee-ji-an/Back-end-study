package ex03;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {	//사용자 한 명의 정보 프린트
	
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 mm월 dd일");
	}
	public void print(Member member) {
		
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보 : 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("회원 정보 : 아이디=%s, 이메일=%s, 이름=%s, 등록일=%s\n", 
				member.getId(), member.getEmail(), member.getName(), 
				dateTimeFormatter.format(member.getRegisterDateTime()));
		}
		
	}
}

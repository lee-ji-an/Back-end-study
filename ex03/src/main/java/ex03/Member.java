package ex03;

import java.time.LocalDateTime;

//회원 정보를 표현
public class Member {
	private long id;  //내부적으로 회원 관리를 위해서 사용하는 id
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	
	//해당 객체가 생성될 때만 값을 설정할 수 있도록 하고,
	//패스워드 변경 기능만 외부에 노출
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}
}

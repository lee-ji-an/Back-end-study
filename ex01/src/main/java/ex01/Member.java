package ex01;

import java.util.Date;
//ȸ�� ������ ���� �� �ִ� ��ü (DTO, Entity ������ ��� ����)

public class Member {//Data�� ������ �ִ� Class
	private String email;
	private String password;
	private String name;
	private Date registDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
	
}

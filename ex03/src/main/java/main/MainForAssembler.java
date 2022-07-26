package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import ex03.ChangePasswordService;
import ex03.DuplicateMemberException;
import ex03.MemberRegisterService;
import ex03.RegisterRequest;

public class MainForAssembler {

	// new => 새로운 회원 데이터를 추가
	// change => 회원의 패스워드를 변경
	// exit => 프로그램 종료
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			// new 이메일 이름 패스워드 패스워드확인
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}
			// change 이메일 현재패스워드 새패스워드
			if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 새암호");
		System.out.println();
	}

	private static Assembler assembler = new Assembler();
	
	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = assembler.getPwdSvc();
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경했습니다.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}	
	}

	private static void processNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();	// <=== 
		RegisterRequest reg = new RegisterRequest();
		reg.setEmail(args[1]);
		reg.setName(args[2]);
		reg.setPassword(args[3]);
		reg.setConfirmPassword(args[4]);
		
		if (!reg.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호가 일치하지 않습니다.");
			return;
		}
		
		try {
			regSvc.regist(reg);
			System.out.println("등록했습니다.");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}	
}

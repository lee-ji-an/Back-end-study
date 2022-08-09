package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import ex03_clone.ChangePasswordService;
import ex03_clone.DuplicateMemberException;
import ex03_clone.MemberInfoPrinter;
import ex03_clone.MemberListPrinter;
import ex03_clone.MemberRegisterService;
import ex03_clone.RegisterRequest;
import ex03_clone.VersionPrinter;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;
	// new => 새로운 회원 데이터를 추가
	// change => 회원의 패스워드를 변경
	// exit => 프로그램 종료
	
	public static void main(String[] args) throws IOException{
		// ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		// ctx = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			// new 이메일 이름 패스워드 패스워드확인
			else if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}
			// change 이메일 현재패스워드 새패스워드
			else if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			else if (command.startsWith("list")) {
				processListCommand(command.split(" "));
				continue;
			}
			else if (command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			}
			
			else if (command.startsWith("version")) {
				processVersionCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}
	
	private static void processVersionCommand(String[] args) {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}

	private static void processInfoCommand(String[] args) {
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(args[1]);
	}

//	private static Assembler assembler = new Assembler();
	
	private static void processListCommand(String[] args) {
		MemberListPrinter memberListPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		memberListPrinter.printAll();
	}


	private static void processNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}
		
//		MemberRegisterService regSvc = assembler.getRegSvc();
		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호가 일치하지 않습니다.");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}
	}

	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		
//		ChangePasswordService changePwdSvc = assembler.getPwdSvc();
		ChangePasswordService changePwdSvc = ctx.getBean(ChangePasswordService.class);
				
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경했습니다.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 새암호");
		System.out.println();
	}
	
	
}


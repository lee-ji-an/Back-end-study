package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConf1;
import config.AppConf2;
import config.AppCtx;
import ex03.ChangePasswordService;
import ex03.DuplicateMemberException;
import ex03.MemberInfoPrinter;
import ex03.MemberListPrinter;
import ex03.MemberRegisterService;
import ex03.RegisterRequest;
import ex03.VersionPrinter;

public class MainForSpring {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException { 
		//ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		//ctx = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
		ctx = new AnnotationConfigApplicationContext(AppConf1.class); //Import�� AppConf1���ص� 2�� �ڵ�����
		//	AnnotationConfigApplicationContext Ŭ������ �����ڴ� 
		//  ���� �����̹Ƿ� ���� Ŭ���� ����� �޸��� �����ؼ� ���� 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("��ɾ �Է��ϼ���.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("�����մϴ�.");
				break;
			}
			// new �̸��� �̸� �н����� �н�����Ȯ��
			else if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}
			// change �̸��� �����н����� ���н�����
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
	
	private static void processVersionCommand(String[] split) {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();	
	}

	private static void processInfoCommand(String[] args) {
//		MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(args[1]);
	}

	private static void processListCommand(String[] args) {
		MemberListPrinter memberListPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		//getBean�ؼ� �����ͼ� ���� ��
		memberListPrinter.printAll();
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("�߸��� ����Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� �����ȣ ����ȣ");
		System.out.println();
	}

	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		
		// ChangePasswordService changePwdSvc = assembler.getPwdSvc();
		ChangePasswordService changePwdSvc = ctx.getBean(ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("��ȣ�� �����߽��ϴ�.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}	
	}

	private static void processNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}
		
		// MemberRegisterService regSvc = assembler.getRegSvc();	// <===
		MemberRegisterService regSvc = ctx.getBean( MemberRegisterService.class);
		RegisterRequest reg = new RegisterRequest();
		reg.setEmail(args[1]);
		reg.setName(args[2]);
		reg.setPassword(args[3]);
		reg.setConfirmPassword(args[4]);
		
		if (!reg.isPasswordEqualToConfirmPassword()) {
			System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
			return;
		}
		
		try {
			regSvc.regist(reg);
			System.out.println("����߽��ϴ�.");
		} catch (DuplicateMemberException e) {
			System.out.println("�̹� �����ϴ� �̸����Դϴ�.");
		}
	}
}


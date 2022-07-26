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

	// new => ���ο� ȸ�� �����͸� �߰�
	// change => ȸ���� �н����带 ����
	// exit => ���α׷� ����
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("��ɾ �Է��ϼ���.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("�����մϴ�.");
				break;
			}
			// new �̸��� �̸� �н����� �н�����Ȯ��
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}
			// change �̸��� �����н����� ���н�����
			if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("�߸��� ����Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� �����ȣ ����ȣ");
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
		
		MemberRegisterService regSvc = assembler.getRegSvc();	// <=== 
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

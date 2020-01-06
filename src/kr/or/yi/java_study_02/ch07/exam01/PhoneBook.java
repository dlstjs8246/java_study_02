package kr.or.yi.java_study_02.ch07.exam01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook {
	void run() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("�ο���>>");
			int num = sc.nextInt();
			Phone[] phone = new Phone[num];
			for(int i=0;i<phone.length;i++) {
				System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� �� ĭ���� �Է�)>>");
				phone[i] = new Phone(sc.next(),sc.next());
			}
			System.out.println("����Ǿ����ϴ�...");
			search(sc,phone);
		}
		catch(InputMismatchException e) {
			System.out.println("���ڸ� ������ �ٸ� ���ڸ� �Է����� ������");
		}
	}
	void search(Scanner sc, Phone[] phone) {
		while(true) {
			int cnt = 0;
			System.out.print("�˻��� �̸�>>");
			String name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			for(int i=0;i<phone.length;i++) {
				if(name.equals(phone[i].getName())) {
					System.out.println(phone[i].getName() + "�� ��ȣ�� " + phone[i].getTel());
					cnt++;
				}
			}
			if(cnt==0) {
				System.out.println("�׷� �̸��� �������� �ʽ��ϴ�.");
			}
		}	
	}
}

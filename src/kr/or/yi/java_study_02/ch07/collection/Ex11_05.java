package kr.or.yi.java_study_02.ch07.collection;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex11_05 {

	public static void main(String[] args) {
		PhoneManagementByArrayList pm = new PhoneManagementByArrayList();
		Scanner sc = new Scanner(System.in);
		int menu;
		System.out.println("��ȭ��ȣ ���� ���α׷��� ���Ű� ȯ���մϴ�.");
		do {
			System.out.print("1.���� 2.���� 3.ã�� 4.��ü���� 5.����>>");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				Phone2 p = insertPhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "�����ϴ� ��ȭ ��ȣ �����Դϴ�.", "����", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.insertPhoneInfo(p);
				break;
			case 2:
				p = deletePhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "�����ϴ� ��ȭ ��ȣ �����Դϴ�.", "����", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.deletePhoneInfo(p);
				break;
			case 3:
				p = findPhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "��ȭ ��ȣ ������ ã�� �� �����ϴ�.", "ã��", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.searchPhoneInfo(p);
				break;
			case 4:
				if(pm.getPhone().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ ã�� �� �����ϴ�.", "��ü��ȸ", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.showPhoneInfo();
				break;
			}
		}while(menu<5);
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
	}

	private static Phone2 deletePhone(PhoneManagementByArrayList pm) {
		Phone2 p = findPhone(pm);
		if(p==null) {
			return null;
		}
		return p;
	}

	private static Phone2 insertPhone(PhoneManagementByArrayList pm) {
		if(findPhone(pm)!=null) {
			return null;
		}
		else {
			String val = JOptionPane.showInputDialog("�̸�,�ּ�,��ȭ��ȣ �Է� ex)���μ�,�뱸 ���� �л�� 2�� 20-6,010-4175-3675");
			String[] data = val.split(",");
			String name = data[0].trim();
			String address = data[1].trim();
			String tel = data[2].trim();
			return new Phone2(name, address, tel);
		}
	}

	private static Phone2 findPhone(PhoneManagementByArrayList pm) {
		String name = JOptionPane.showInputDialog("ã���� �ϴ� �̸� ex)���μ�");
		if(pm.getPhone().contains(new Phone2(name))) {
			return new Phone2(name);
		}
		return null;
	}

}

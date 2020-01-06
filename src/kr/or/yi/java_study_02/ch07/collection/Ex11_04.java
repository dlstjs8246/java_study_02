package kr.or.yi.java_study_02.ch07.collection;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex11_04 {
	public static void main(String[] args) {
		PhoneManagementByHashMap pm = new PhoneManagementByHashMap();
		Scanner sc = new Scanner(System.in);
		int menu;
		System.out.println("��ȭ��ȣ ���� ���α׷��� ���Ű� ȯ���մϴ�.");
		do {
			System.out.print("1.���� 2.���� 3.ã�� 4.��ü���� 5.����>>");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				HashMap<String,Phone> insertPhoneInfo = insertPhone(pm);	
				pm.insertPhoneInfo(insertPhoneInfo);
				break;
			case 2:
				HashMap<String,Phone> deletePhoneInfo = deletePhone(pm);
				if(deletePhoneInfo==null) {
					JOptionPane.showMessageDialog(null, "�̸��� ã�� �� �����ϴ�.", "����", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.deletePhoneInfo(deletePhoneInfo);
				break;
			case 3:
				HashMap<String,Phone> searchPhoneInfo = searchPhone(pm);
				if(searchPhoneInfo==null) {
					JOptionPane.showMessageDialog(null, "�̸��� ã�� �� �����ϴ�.", "�˻�", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.searchPhoneInfo(searchPhoneInfo);
				break;
			case 4:
				if(pm.getPhone().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ ������ ���� ��ȸ�Ҽ� �����ϴ�.", "��ü��ȸ", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.showPhoneInfo();
				break;
			}
		}while(menu<5);
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
	}

	private static HashMap<String, Phone> deletePhone(PhoneManagementByHashMap pm) {
		return searchPhone(pm);
	}

	private static HashMap<String, Phone> searchPhone(PhoneManagementByHashMap pm) {
		HashMap<String, Phone> phones = new HashMap<String, Phone>();
		String val = JOptionPane.showInputDialog("�̸��� �Է����ּ��� ex)���μ�");
		if(pm.getPhone().containsKey(val)) {	
			 phones.put(val,new Phone(null,null));
			 return phones;
		}
		return null;
	}

	private static HashMap<String, Phone> insertPhone(PhoneManagementByHashMap pm) {
		HashMap<String, Phone> phones = new HashMap<String, Phone>();
		String val = JOptionPane.showInputDialog("�̸��� �Է����ּ��� ex)���μ�");
		if(!phones.containsKey(val)) {	
			 String str = JOptionPane.showInputDialog("�ּҿ� ��ȭ��ȣ�� �Է��ϼ��� ex)�뱸 ���� �л��2�� 20-6,010-4175-3675");
			 String[] phoneInfo = str.split(",");
			 String address = phoneInfo[0].trim();
			 String tel = phoneInfo[1].trim();
			 phones.put(val, new Phone(address,tel));
		}
		else {
			 JOptionPane.showMessageDialog(null, "�̸��� �����մϴ�. �ּҿ� ��ȭ��ȣ�� ����ϴ�.");
			 String str = JOptionPane.showInputDialog("�ּҿ� ��ȭ��ȣ�� �Է��ϼ��� ex)�뱸 ���� �л��2�� 20-6,010-4175-3675");
			 String[] phoneInfo = str.split(",");
			 String address = phoneInfo[0].trim();
			 String tel = phoneInfo[1].trim();
			 phones.put(val, new Phone(address,tel));
		}
		return phones;
	}
}

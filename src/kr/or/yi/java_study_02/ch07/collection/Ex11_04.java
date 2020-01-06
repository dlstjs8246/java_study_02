package kr.or.yi.java_study_02.ch07.collection;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex11_04 {
	public static void main(String[] args) {
		PhoneManagementByHashMap pm = new PhoneManagementByHashMap();
		Scanner sc = new Scanner(System.in);
		int menu;
		System.out.println("전화번호 관리 프로그램에 오신걸 환영합니다.");
		do {
			System.out.print("1.삽입 2.삭제 3.찾기 4.전체보기 5.종료>>");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				HashMap<String,Phone> insertPhoneInfo = insertPhone(pm);	
				pm.insertPhoneInfo(insertPhoneInfo);
				break;
			case 2:
				HashMap<String,Phone> deletePhoneInfo = deletePhone(pm);
				if(deletePhoneInfo==null) {
					JOptionPane.showMessageDialog(null, "이름을 찾을 수 없습니다.", "삭제", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.deletePhoneInfo(deletePhoneInfo);
				break;
			case 3:
				HashMap<String,Phone> searchPhoneInfo = searchPhone(pm);
				if(searchPhoneInfo==null) {
					JOptionPane.showMessageDialog(null, "이름을 찾을 수 없습니다.", "검색", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.searchPhoneInfo(searchPhoneInfo);
				break;
			case 4:
				if(pm.getPhone().isEmpty()) {
					JOptionPane.showMessageDialog(null, "전화번호 정보가 없어 조회할수 없습니다.", "전체조회", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.showPhoneInfo();
				break;
			}
		}while(menu<5);
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

	private static HashMap<String, Phone> deletePhone(PhoneManagementByHashMap pm) {
		return searchPhone(pm);
	}

	private static HashMap<String, Phone> searchPhone(PhoneManagementByHashMap pm) {
		HashMap<String, Phone> phones = new HashMap<String, Phone>();
		String val = JOptionPane.showInputDialog("이름을 입력해주세요 ex)박인선");
		if(pm.getPhone().containsKey(val)) {	
			 phones.put(val,new Phone(null,null));
			 return phones;
		}
		return null;
	}

	private static HashMap<String, Phone> insertPhone(PhoneManagementByHashMap pm) {
		HashMap<String, Phone> phones = new HashMap<String, Phone>();
		String val = JOptionPane.showInputDialog("이름을 입력해주세요 ex)박인선");
		if(!phones.containsKey(val)) {	
			 String str = JOptionPane.showInputDialog("주소와 전화번호를 입력하세요 ex)대구 동구 둔산로2길 20-6,010-4175-3675");
			 String[] phoneInfo = str.split(",");
			 String address = phoneInfo[0].trim();
			 String tel = phoneInfo[1].trim();
			 phones.put(val, new Phone(address,tel));
		}
		else {
			 JOptionPane.showMessageDialog(null, "이름이 존재합니다. 주소와 전화번호를 덮어씁니다.");
			 String str = JOptionPane.showInputDialog("주소와 전화번호를 입력하세요 ex)대구 동구 둔산로2길 20-6,010-4175-3675");
			 String[] phoneInfo = str.split(",");
			 String address = phoneInfo[0].trim();
			 String tel = phoneInfo[1].trim();
			 phones.put(val, new Phone(address,tel));
		}
		return phones;
	}
}

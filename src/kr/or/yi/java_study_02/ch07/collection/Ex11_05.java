package kr.or.yi.java_study_02.ch07.collection;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex11_05 {

	public static void main(String[] args) {
		PhoneManagementByArrayList pm = new PhoneManagementByArrayList();
		Scanner sc = new Scanner(System.in);
		int menu;
		System.out.println("전화번호 관리 프로그램에 오신걸 환영합니다.");
		do {
			System.out.print("1.삽입 2.삭제 3.찾기 4.전체보기 5.종료>>");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				Phone2 p = insertPhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "존재하는 전화 번호 정보입니다.", "삽입", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.insertPhoneInfo(p);
				break;
			case 2:
				p = deletePhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "존재하는 전화 번호 정보입니다.", "삭제", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.deletePhoneInfo(p);
				break;
			case 3:
				p = findPhone(pm);
				if(p==null) {
					JOptionPane.showMessageDialog(null, "전화 번호 정보를 찾을 수 없습니다.", "찾기", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.searchPhoneInfo(p);
				break;
			case 4:
				if(pm.getPhone().isEmpty()) {
					JOptionPane.showMessageDialog(null, "전화번호 정보를 찾을 수 없습니다.", "전체조회", JOptionPane.WARNING_MESSAGE);
					break;
				}
				pm.showPhoneInfo();
				break;
			}
		}while(menu<5);
		System.out.println("프로그램을 종료합니다.");
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
			String val = JOptionPane.showInputDialog("이름,주소,전화번호 입력 ex)박인선,대구 동구 둔산로 2길 20-6,010-4175-3675");
			String[] data = val.split(",");
			String name = data[0].trim();
			String address = data[1].trim();
			String tel = data[2].trim();
			return new Phone2(name, address, tel);
		}
	}

	private static Phone2 findPhone(PhoneManagementByArrayList pm) {
		String name = JOptionPane.showInputDialog("찾고자 하는 이름 ex)박인선");
		if(pm.getPhone().contains(new Phone2(name))) {
			return new Phone2(name);
		}
		return null;
	}

}

package kr.or.yi.java_study_02.ch07.collection;

import java.util.ArrayList;

public class PhoneManagementByArrayList implements PhoneMgnInterfaceByArrayList {
	private ArrayList<Phone2> phone;
	
	
	public ArrayList<Phone2> getPhone() {
		return phone;
	}

	public void setPhone(ArrayList<Phone2> phone) {
		this.phone = phone;
	}

	public PhoneManagementByArrayList() {
		phone = new ArrayList<Phone2>();
	}

	@Override
	public void insertPhoneInfo(Phone2 phone) {
		this.phone.add(phone);
	}

	@Override
	public void deletePhoneInfo(Phone2 phone) {
		this.phone.remove(this.phone.indexOf(phone));
	}

	@Override
	public void searchPhoneInfo(Phone2 phone) {
		System.out.println(this.phone.get(this.phone.indexOf(phone)));
	}

	@Override
	public void showPhoneInfo() {
		for(Phone2 p : phone) {
			System.out.println(p);
		}
	}

}

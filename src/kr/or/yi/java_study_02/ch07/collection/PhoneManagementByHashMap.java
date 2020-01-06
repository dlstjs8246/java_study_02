package kr.or.yi.java_study_02.ch07.collection;

import java.util.*;

public class PhoneManagementByHashMap implements PhoneMsgInterfaceByHashMap {
	private HashMap<String, Phone> phoneMap;
	
	public PhoneManagementByHashMap() {
		phoneMap = new HashMap<String, Phone>();
	}

	public HashMap<String, Phone> getPhone() {
		return phoneMap;
	}

	public void setPhone(HashMap<String, Phone> phone) {
		this.phoneMap = phone;
	}
	@Override
	public void deletePhoneInfo(HashMap<String, Phone> deletePhoneInfo) {
		String key = null;
		Set <String> keys = deletePhoneInfo.keySet();
		Iterator<String> it = keys.iterator();
		key = it.next();
		System.out.print("name=" + key + ", " + phoneMap.get(key));
		phoneMap.remove(key);
	}

	@Override
	public void insertPhoneInfo(HashMap<String, Phone> phones) {
		String key = null;
		Set <String> keys = phones.keySet();
		Iterator<String> it = keys.iterator();
		key = it.next();
		phoneMap.put(key, phones.get(key));
	}

	@Override
	public void searchPhoneInfo(HashMap<String, Phone> searchPhoneInfo) {
		Set<String> keys = searchPhoneInfo.keySet();
		Iterator<String> it = keys.iterator();
		String key = it.next();
		System.out.print("name=" + key + ", " + phoneMap.get(key));
	}

	@Override
	public void showPhoneInfo() {
		String key = null;
		Set <String> keys = phoneMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			key = it.next();
			System.out.print("name=" + key + ", " + phoneMap.get(key));
		}
	}
}

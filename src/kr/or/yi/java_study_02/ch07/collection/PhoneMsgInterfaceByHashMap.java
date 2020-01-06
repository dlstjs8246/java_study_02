package kr.or.yi.java_study_02.ch07.collection;

import java.util.HashMap;

public interface PhoneMsgInterfaceByHashMap {
	public void insertPhoneInfo(HashMap<String, Phone> phones);
	public void deletePhoneInfo(HashMap<String, Phone> deletePhoneInfo);
	public void searchPhoneInfo(HashMap<String, Phone> searchPhoneInfo);
	public void showPhoneInfo();	
}

package kr.or.yi.java_study_02.ch07.collection;

public class Phone {
	private String address;
	private String tel;
	
	public Phone() {

	}
	
	public Phone(String address, String tel) {
		this.address = address;
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return String.format("address=%s, tel=%s%n",address, tel);
	}
	
}

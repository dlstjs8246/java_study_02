package kr.or.yi.java_study_02.ch06;

public class Sale {
	private int no;
	private String name;
	private int price;
	private int saleCnt;
	private int marginRate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleCnt() {
		return saleCnt;
	}
	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}
	public int getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}
	@Override
	public String toString() {
		return String.format("[%s, %s, %s, %s, %s]", no, name, price, saleCnt,
				marginRate);
	}
	
}

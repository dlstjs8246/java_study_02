package kr.or.yi.java_study_02.ch07;

public class MyClass<T> {
	private T val;
	
	
	public T getVal() {
		return val;
	}


	public void setVal(T val) {
		this.val = val;
	}


	public static void main(String[] args) {
		MyClass<String> strClass = new MyClass<String>();
		MyClass<Integer> intClass = new MyClass<Integer>();
		strClass.setVal("test");
		intClass.setVal(5);
		System.out.println(strClass.getVal());
		System.out.println(intClass.getVal());
	}
}

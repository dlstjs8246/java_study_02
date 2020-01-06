package kr.or.yi.java_study_02.ch06;

public class Rect {
	private int width;
	private int height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int getArea() {
		return width * height;
	}
	@Override
	public int hashCode() {
		return width + height;
	}
	@Override
	public boolean equals(Object obj) {
		Rect other = (Rect)obj;
		return getArea()==other.getArea();
	}
	public static void main(String[] args) {
		Rect a = new Rect(2,3);
		Rect b = new Rect(3,2);
		Rect c = new Rect(3,4);
		
		if(a.equals(b)) {
			System.out.println("a is equal to b");
		}
		if(a.equals(c)) {
			System.out.println("a is equal to c");
		}
		if(b.equals(c)) {
			System.out.println("b is equal to c");
		}
	}
	
}

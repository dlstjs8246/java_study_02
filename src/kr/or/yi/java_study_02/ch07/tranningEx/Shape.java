package kr.or.yi.java_study_02.ch07.tranningEx;

public abstract class Shape {
	private Shape next;

	public Shape getNext() {
		return next;
	}

	public void setNext(Shape next) {
		this.next = next;
	}
	public abstract void draw();
}

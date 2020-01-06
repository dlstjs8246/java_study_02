package kr.or.yi.java_study_02.ch07;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return String.format("Point [x=%s, y=%s]", x, y);
	}
	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}

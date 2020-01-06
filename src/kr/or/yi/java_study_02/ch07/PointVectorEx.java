package kr.or.yi.java_study_02.ch07;

import java.util.Vector;

public class PointVectorEx {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();
		
		v.add(new Point(2,3));
		v.add(new Point(-5,20));
		v.add(new Point(30,-8));
		
		v.remove(1);
		
		for(Point p : v) {
			System.out.println(p);
		}
		
		System.out.println(v.contains(new Point(30,-8)));
		System.out.println(v.indexOf(new Point(30,-8)));
		v.remove(new Point(30,-8));
		System.out.println(v);
	}
}

package kr.or.yi.java_study_02.ch07;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2,100);
		
		System.out.println("���� ���� ��� ��ü �� : " + v.size());
		System.out.println("������ ���� �뷮 : " + v.capacity());
		int sum = 0;
		for(int a : v) {
			System.out.println(a);
			sum += a;
		}
		System.out.println("���Ϳ� �ִ� ���� �� : " + sum);
	}

}

package kr.or.yi.java_study_02.ch07;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2,100);
		
		System.out.println("벡터 내의 요소 객체 수 : " + v.size());
		System.out.println("벡터의 현재 용량 : " + v.capacity());
		int sum = 0;
		for(int a : v) {
			System.out.println(a);
			sum += a;
		}
		System.out.println("벡터에 있는 정수 합 : " + sum);
	}

}

package kr.or.yi.java_study_02.ch07.collection;

import java.util.*;

public class Ex11_03 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("ȫ�浿",1,1,100,100,100));
		list.add(new Student("���ü�",1,2,90,70,80));
		list.add(new Student("���ڹ�",1,3,80,80,90));
		list.add(new Student("���ڹ�",1,4,70,90,70));
		list.add(new Student("���ڹ�",1,5,60,100,80));
		Collections.sort(list);
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

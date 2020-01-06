package kr.or.yi.java_study_02.ch06;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectEquals {
	public static void main(String[] args) {
		Student[] stdArr = {
				new Student(5,"장현서",80,80,70),
				new Student(3,"유경진",81,90,70),
				new Student(4,"권수진",82,100,70),
				new Student(1,"정아름",83,89,70),
				new Student(2,"김민수",84,69,70)
		};
//		do_equals();	
//		do_sort(stdArr);
//		do_search(stdArr);
//		prn_Object(stdArr[0]);
		
	}

	private static void prn_Object(Object obj) {
		System.out.println(obj.getClass().getName()); //풀패키지명 + 클래스명
		System.out.println(obj.getClass().getSimpleName()); //클래스명
	}

	private static void do_search(Student[] stdArr) {
		//검색
		Arrays.sort(stdArr);
		prnStds(stdArr);
		Student findStd = new Student(6);
		int findIdx = Arrays.binarySearch(stdArr, findStd);
		System.out.println(findStd + "의 위치는 " + findIdx);
	}

	private static void do_sort(Student[] stdArr) {
		//학번 순으로 정렬(기본정렬)
		prnStds(stdArr);
		Arrays.sort(stdArr);
		prnStds(stdArr);
		
		//기본 정렬 외 국어점수로 정렬
		Comparator<Student> korOrder = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getKor() - o1.getKor();
			}
		};
		Arrays.sort(stdArr, korOrder);
		System.out.println("국어 점수별 정렬");
		prnStds(stdArr);
		
		Comparator<Student> engOrder = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.getEng() - o1.getEng();
			}
			
		};
		//기본 정렬 외 영어점수로 정렬
		Arrays.sort(stdArr, engOrder);
		System.out.println("영어 점수별 정렬");
		prnStds(stdArr);
	}

	private static void prnStds(Student[] stdArr) {
		for(Student s : stdArr) {
			System.out.println(s);
		}
	}

	private static void do_equals() {
		Student std01 = new Student(1, "이상원", 90, 90, 90);
		Student std02 = new Student(1, "이상원", 90, 90, 90);
		
		if(std01.equals(std02)) {
			System.out.println("같은 학생");
		}
		else {
			System.out.println("다른 학생");
		}
		System.out.println("std01 : " + std01.hashCode());
		System.out.println("std02 : " + std02.hashCode());
	}
}

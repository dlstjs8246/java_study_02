package kr.or.yi.java_study_02.ch06;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectEquals {
	public static void main(String[] args) {
		Student[] stdArr = {
				new Student(5,"������",80,80,70),
				new Student(3,"������",81,90,70),
				new Student(4,"�Ǽ���",82,100,70),
				new Student(1,"���Ƹ�",83,89,70),
				new Student(2,"��μ�",84,69,70)
		};
//		do_equals();	
//		do_sort(stdArr);
//		do_search(stdArr);
//		prn_Object(stdArr[0]);
		
	}

	private static void prn_Object(Object obj) {
		System.out.println(obj.getClass().getName()); //Ǯ��Ű���� + Ŭ������
		System.out.println(obj.getClass().getSimpleName()); //Ŭ������
	}

	private static void do_search(Student[] stdArr) {
		//�˻�
		Arrays.sort(stdArr);
		prnStds(stdArr);
		Student findStd = new Student(6);
		int findIdx = Arrays.binarySearch(stdArr, findStd);
		System.out.println(findStd + "�� ��ġ�� " + findIdx);
	}

	private static void do_sort(Student[] stdArr) {
		//�й� ������ ����(�⺻����)
		prnStds(stdArr);
		Arrays.sort(stdArr);
		prnStds(stdArr);
		
		//�⺻ ���� �� ���������� ����
		Comparator<Student> korOrder = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getKor() - o1.getKor();
			}
		};
		Arrays.sort(stdArr, korOrder);
		System.out.println("���� ������ ����");
		prnStds(stdArr);
		
		Comparator<Student> engOrder = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.getEng() - o1.getEng();
			}
			
		};
		//�⺻ ���� �� ���������� ����
		Arrays.sort(stdArr, engOrder);
		System.out.println("���� ������ ����");
		prnStds(stdArr);
	}

	private static void prnStds(Student[] stdArr) {
		for(Student s : stdArr) {
			System.out.println(s);
		}
	}

	private static void do_equals() {
		Student std01 = new Student(1, "�̻��", 90, 90, 90);
		Student std02 = new Student(1, "�̻��", 90, 90, 90);
		
		if(std01.equals(std02)) {
			System.out.println("���� �л�");
		}
		else {
			System.out.println("�ٸ� �л�");
		}
		System.out.println("std01 : " + std01.hashCode());
		System.out.println("std02 : " + std02.hashCode());
	}
}

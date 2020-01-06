package kr.or.yi.java_study_02.ch07.tranningEx;

import java.util.ArrayList;

public class StudentMgnByArrayList implements StdMgnInterfaceByArrayList {
	private ArrayList<Student> stdList;
	
	public StudentMgnByArrayList() {
		stdList = new ArrayList<Student>();
	}

	@Override
	public void insertStd(Student std) {
		stdList.add(std);
	}

	@Override
	public void findStd(Student std) {
		if(stdList.contains(std)) {
			System.out.println(stdList.get(stdList.indexOf(std)));
		}
	}

	@Override
	public void prnStd() {
		System.out.println("------------");
		for(Student s : stdList) {
			System.out.println("이름 : " + s.getName());
			System.out.println("학과 : " + s.getDeptName());
			System.out.println("학번 : " + s.getDeptNo());
			System.out.println("학정평균 : " + s.getScoreAvg());
			System.out.println("------------");
		}
	}

}

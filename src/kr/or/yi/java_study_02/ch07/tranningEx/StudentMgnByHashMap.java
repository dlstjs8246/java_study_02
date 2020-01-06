package kr.or.yi.java_study_02.ch07.tranningEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class StudentMgnByHashMap implements StdMgnInterfaceByHashMap {
	private HashMap<String,Student> student;
	
	public StudentMgnByHashMap() {
		student = new HashMap<String, Student>();
	}

	@Override
	public void insertStdMap(HashMap<String, Student> student) {
		Set <String> keys = student.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			this.student.put(key, student.get(key));
		}
	}

	@Override
	public void searchStdMap(HashMap<String, Student> student) {
		Set <String> keys = student.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(this.student.containsKey(key)) {
				System.out.println(this.student.get(key));
			}
			else {
				System.out.println("�׷� �л��� �����ϴ�.");
			}
		}
	}

	@Override
	public void prnStdMap() {
		Set <String> keys = student.keySet();
		Iterator<String> it = keys.iterator();
		String[] keyArr = new String[keys.size()];
		System.out.println("------------------");
		for(int i=0;i<keyArr.length;i++) {
			if(it.hasNext()) {
				keyArr[i] = it.next();
				System.out.println("�̸� : " + student.get(keyArr[i]).getName());
				System.out.println("�а� : " + student.get(keyArr[i]).getDeptName());
				System.out.println("�й� : " + student.get(keyArr[i]).getDeptNo());
				System.out.println("������� : " + student.get(keyArr[i]).getScoreAvg());
				System.out.println("------------------");
			}
		}
	}

}

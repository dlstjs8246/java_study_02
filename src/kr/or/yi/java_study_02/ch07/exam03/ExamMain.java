package kr.or.yi.java_study_02.ch07.exam03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import kr.or.yi.java_study_02.ch07.exam02.Student;

public class ExamMain {
 
	public static void main(String[] args) {
		StdMgnForHashMap sm = new StdMgnForHashMap();
		
		for(Student std : initStdList()) {
			sm.insertStudent(std);
		}
		
		Scanner sc = new Scanner(System.in);
		int res;
		do {
			System.out.println("1. 학생목록, 2. 학생추가, 3. 학생 수정, 4. 학생 삭제, 5. 학생검색, 6. 종료");
			res = sc.nextInt();
			System.out.println(res);
			switch(res) {
			case 1:
				prnStudents(sm.listStudent());
				break;
			case 2:
				System.out.printf("%s%n", "학생추가");
				Student insertStd = insertStudent(sm);
				if(insertStd==null) {
					sm.insertStudent(insertStd);
					break;
				}
				System.out.println(sm.searchStudent(insertStd));
				break;
			case 3:
				System.out.printf("%s%n", "학생 수정");
				Student updateStd = updateStdudent(sm);
				if(updateStd==null) {
					break;
				}
				sm.updateStudent(updateStd);
				System.out.println(sm.searchStudent(updateStd));
				break;
			case 4:
				System.out.printf("%s%n", "학생 삭제");
				Student deleteStd = deleteStdudent(sm);
				if(deleteStd==null) {
					break;
				}
				System.out.println(sm.searchStudent(deleteStd));
				sm.deleteStudent(deleteStd);
				break;
			case 5:
				System.out.printf("%s%n", "학생 검색");
				Student findStd = searchStudent("찾을 학생 번호");
				System.out.println(sm.searchStudent(findStd));
				break;
			
			}
		}while(res < 6);
		System.out.println("학생관리 프로그램을 종료합니다.");
		sc.close();
	}

	private static Student deleteStdudent(StdMgnForHashMap sm) {
		Student deleteStd = searchStudent("삭제할 학생 번호");
		if(sm.searchStudent(deleteStd)==null) {
			JOptionPane.showMessageDialog(null, "삭제할 학생 번호가 존재하지 않습니다.", "수정", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		else {
			return sm.searchStudent(deleteStd);
		}
	}

	private static Student updateStdudent(StdMgnForHashMap sm) {
		Student updateStd = searchStudent("수정할 학생 번호");
		if(sm.searchStudent(updateStd)==null) {
			JOptionPane.showMessageDialog(null, "수정할 학생 번호가 존재하지 않습니다.", "수정", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		else {
			updateStd = sm.searchStudent(updateStd);
			String res = JOptionPane.showInputDialog("수정할 학생 정보 : 국어,수학,영어 ex)90,90,90");
			String[] resArr = res.split(",");
			updateStd.setKor(Integer.parseInt(resArr[0].trim()));
			updateStd.setEng(Integer.parseInt(resArr[1].trim()));
			updateStd.setMath(Integer.parseInt(resArr[2].trim()));
			return updateStd;
		}
	}

	private static Student insertStudent(StdMgnForHashMap sm) {
		Student insertStd = searchStudent("입력할 학생 번호");
		if(sm.searchStudent(insertStd)!=null) {
			JOptionPane.showMessageDialog(null, "입력할 학생 번호가 존재합니다.", "입력", JOptionPane.WARNING_MESSAGE);
			return sm.searchStudent(insertStd);
		}
		else {
			String res = JOptionPane.showInputDialog("입력하고자 하는 학생 정보 : 이름,국어,수학,영어 ex)이상원,90,90,90");
			String[] resArr = res.split(",");
			int stdNo = insertStd.getStdNo();
			String stdName = resArr[0].trim();
			int kor = Integer.parseInt(resArr[1].trim());
			int eng = Integer.parseInt(resArr[2].trim());
			int math = Integer.parseInt(resArr[3].trim());
			return new Student(stdNo, stdName, kor, eng, math);
		}
	}

	private static Student searchStudent(String msg) {
		String res = JOptionPane.showInputDialog(msg);
		return new Student(Integer.parseInt(res.trim()));
	}

	private static void prnStudents(ArrayList<Student> listStudent) {
		for(Student std : listStudent) {
			System.out.println(std);
		}
	}
	
	private static ArrayList<Student> initStdList() {
		ArrayList<Student> arList = new ArrayList<>();
		Random rnd = new Random();
		String[] names = {"권수진", "정아름", "장현서", "황태원", 
				"배진우", "현재승", "이동주", "황하나", "유경진", "이상원", "박인선"};
		for(int i=0; i<names.length; i++) {
			arList.add(new Student(i+1, names[i], 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41));
		}
		
		return arList;
	}

}

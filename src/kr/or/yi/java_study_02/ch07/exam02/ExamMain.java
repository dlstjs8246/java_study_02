

package kr.or.yi.java_study_02.ch07.exam02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExamMain {
 
	public static void main(String[] args) {
		/*
		1. 학생정보를 관리하는 프로그램을 작성하세요.
		2. 학생클래스를 정의(번호, 성명, 국어, 영어, 수학) 
		3. 학생관리클래스정의(StudentManagement) StdManagerInterface를 구현한
		4. 메뉴작성(1. 학생목록, 2. 학생추가, 3. 학생 수정, 4. 학생 삭제, 5. 학생 검색,  6. 종료)
		*/

		StudentManagement sm = new StudentManagement();
		sm.setStudentList(initStdList());
		
		Scanner sc = new Scanner(System.in);
		int res;
		do {
			System.out.println("1. 학생목록, 2. 학생추가, 3. 학생 수정, 4. 학생 삭제, 5. 학생 검색, 6.정렬, 7.종료");
			res = sc.nextInt();
			System.out.println(res);
			switch(res) {
			case 1:
				System.out.println("1. 학생목록");
				prnStudents(sm.listStudent());
				break;
			case 2:
				System.out.println("2. 학생추가");
				Student insertStd = getStudent();
				sm.insertStudent(insertStd);
				break;
			case 3:
				System.out.println("3. 학생 수정");
				Student updateStd = updateStudent();
				sm.updateStudent(updateStd);
				break;
			case 4:
				System.out.println("4. 학생 삭제");
				Student deleteStd = searchStudent("삭제할 학생 번호");
				sm.deleteStudent(deleteStd);
				break;
			case 5:
				System.out.println("5. 학생 검색");
				Student searchStd = searchStudent("찾을 학생 번호");
				System.out.println(sm.searchStudent(searchStd));
				break;
			case 6:
				System.out.println("6. 정렬");
				Comparator<Student>align = sortStudent();
				sm.sort(align);
				break;
			}
		}while(res < 7);
		System.out.println("학생관리 프로그램을 종료합니다.");
		sc.close();
	}

	private static Comparator<Student> sortStudent() {
		String res = JOptionPane.showInputDialog("정렬할 학생 정보 1.학번순 2.국어순 3.수학순 4.영어순 5.총점순 ex)1");
		int menu = Integer.parseInt(res);
		switch(menu) {
		case 1:
			return null;
		case 2:
			return new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getKor()-o2.getKor();
				}
			};
		case 3:
			return new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getEng()-o2.getEng();
				}
			};
		case 4:
			return new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getMath()-o2.getMath();
				}
			};
		case 5:
			return new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.total()-o2.total();
				}
			};
		}
		return null;
	}

	private static Student updateStudent() {
		Student findStd = searchStudent("수정할 학생 번호");
		if(findStd!=null) {
			String res = JOptionPane.showInputDialog("수정할 학생정보 :국어,수학,영어 ex)90,90,90");
			String[] resArr = res.split(",");
			findStd.setKor(Integer.parseInt(resArr[0].trim()));
			findStd.setEng(Integer.parseInt(resArr[1].trim()));
			findStd.setMath(Integer.parseInt(resArr[2].trim()));
			return findStd;
		}
		return null;
	}

	private static Student searchStudent(String msg) { 
		String res = JOptionPane.showInputDialog(msg);
		return new Student(Integer.parseInt(res.trim()));
	}

	private static Student getStudent() { 
		Student findStd = searchStudent("입력할 학생 번호");
		if(findStd==null) {
			String res = JOptionPane.showInputDialog("입력할 학생정보 :번호, 이름, 성명, 국어, 수학, 영어 ex)1,이상원,90,90,90");
			String[] resArr = res.split(",");
			int stdNo = Integer.parseInt(resArr[0].trim());
			String stdName = resArr[1];
			int kor = Integer.parseInt(resArr[2].trim());
			int math = Integer.parseInt(resArr[3].trim());
			int eng = Integer.parseInt(resArr[4].trim());
			return new Student(stdNo, stdName, kor, math, eng);
		}
		return findStd;
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

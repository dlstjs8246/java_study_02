package kr.or.yi.java_study_02.ch07.exam02;

import java.util.*;

import javax.swing.JOptionPane;

public class StudentManagement implements StdManagerInterface {
	private ArrayList<Student> stdList;
	
	
	public StudentManagement() {
		this.stdList = new ArrayList<Student>();
	}

	@Override
	public boolean insertStudent(Student student) {
		return stdList.add(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		return stdList.remove(student);
	}

	@Override
	public ArrayList<Student> listStudent() {
		return this.stdList ;
	}

	@Override
	public boolean updateStudent(Student student) {
		this.stdList.set(stdList.indexOf(student), student);
		return true;
	}

	@Override
	public Student searchStudent(Student student) {
		if(!stdList.equals(student)) {
			JOptionPane.showInputDialog(null, "학생 번호가 존재하지 않습니다");
			return null;
		}
		return stdList.get(stdList.indexOf(student));
	}

	public void setStudentList(ArrayList<Student> initStdList) {
		this.stdList = initStdList;
	}
	
	public void sort(Comparator<Student> align) {
		if(align==null) {
			Collections.sort(stdList);
			return;
		}
		Collections.sort(stdList,align);
	}
}

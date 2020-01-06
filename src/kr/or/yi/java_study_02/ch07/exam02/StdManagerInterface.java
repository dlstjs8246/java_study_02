package kr.or.yi.java_study_02.ch07.exam02;

import java.util.ArrayList;

public interface StdManagerInterface {
	
	public boolean insertStudent(Student student);
	
	public boolean deleteStudent(Student student);
	
	public ArrayList<Student> listStudent();
	
	public boolean updateStudent(Student student);
	
	public Student searchStudent(Student student);
	
}

package kr.or.yi.java_study_02.ch07.exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

import kr.or.yi.java_study_02.ch07.exam02.StdManagerInterface;
import kr.or.yi.java_study_02.ch07.exam02.Student;


public class StdMgnForHashMap implements StdManagerInterface {
	private HashMap<Integer, Student> stdMap;
	
	
	public StdMgnForHashMap() {
		this.stdMap = new HashMap<Integer, Student>();
	}
	/**
	 * put 중복일 경우 value 값 리턴 추가된 경우 null 리턴
	 *
	 */
	@Override
	public boolean insertStudent(Student student) {
		Student res = stdMap.put(student.getStdNo(), student);
		return res==null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		return stdMap.remove(student.getStdNo(),student);
	}

	@Override
	public ArrayList<Student> listStudent() {
		ArrayList<Student> stdlist = new ArrayList<Student>();
		Set<Integer> keys = stdMap.keySet();
		for(Integer stdNo : keys) {
			stdlist.add(stdMap.get(stdNo));
		}
		return stdlist;
	}

	@Override
	public boolean updateStudent(Student student) {
		Student res = stdMap.put(student.getStdNo(), student);
		return res!=null;
	}

	@Override
	public Student searchStudent(Student student) {
		if(stdMap.get(student.getStdNo())==null) {
			JOptionPane.showMessageDialog(null, "해당 하는 학생의 정보를 찾을 수 없습니다.", "검색", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return stdMap.put(student.getStdNo(), listStudent().get(student.getStdNo()-1));
	}
}

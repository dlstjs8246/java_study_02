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
	 * put �ߺ��� ��� value �� ���� �߰��� ��� null ����
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
			JOptionPane.showMessageDialog(null, "�ش� �ϴ� �л��� ������ ã�� �� �����ϴ�.", "�˻�", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return stdMap.put(student.getStdNo(), listStudent().get(student.getStdNo()-1));
	}
}

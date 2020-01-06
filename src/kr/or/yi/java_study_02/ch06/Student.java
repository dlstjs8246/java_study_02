package kr.or.yi.java_study_02.ch06;

public class Student implements Comparable<Student> {
	private int stdNo;
	private String stdName;
	private int kor;
	private int eng;
	private int math;
	public Student() {

	}
	public Student(int stdNo) {
		this.stdNo = stdNo;
	}
	public Student(int stdNo, String stdName, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return String.format("[%s, %s, %s, %s, %s]", stdNo, stdName, kor, eng, math);
	}
	@Override
	public int hashCode() {
		return stdNo;
	}
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return stdNo == other.stdNo;
	}
	@Override
	public int compareTo(Student o) {
		return this.stdNo - o.stdNo; //반대로 빼주면 역순으로 정렬(desc)
	}
	
	
}

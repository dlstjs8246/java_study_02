package kr.or.yi.java_study_02.ch07.collection;

public class Student implements Comparable<Student> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getTotal() {
		return kor + eng + math;
	}
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5)/10f;
	}
	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, no=%s, kor=%s, eng=%s, math=%s]", name, ban, no, kor, eng,
				math);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return name==other.name;
	}
	@Override
	public int compareTo(Student o) {
		return name.hashCode() - o.name.hashCode();
	}
	
}

package kr.or.yi.java_study_02.ch07.tranningEx;

public class Student {
	private String name;
	private String deptName;
	private int deptNo;
	private double scoreAvg;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String name) {
		this.name = name;
	}


	public Student(String name, String deptName, int deptNo, double scoreAvg) {
		this.name = name;
		this.deptName = deptName;
		this.deptNo = deptNo;
		this.scoreAvg = scoreAvg;
	}
	
	public String getName() {
		return name;
	}


	public String getDeptName() {
		return deptName;
	}


	public int getDeptNo() {
		return deptNo;
	}


	public double getScoreAvg() {
		return scoreAvg;
	}


	@Override
	public String toString() {
		return String.format("%s, %s, %d, %.2f",name,deptName,deptNo,scoreAvg);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return name.hashCode()==other.name.hashCode();
	}
	
}

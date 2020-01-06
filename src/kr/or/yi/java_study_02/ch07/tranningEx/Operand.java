package kr.or.yi.java_study_02.ch07.tranningEx;

public class Operand {
	private String oper;
	private String name;
	private String value;
	public Operand(String oper, String name, String value) {
		this.oper = oper;
		this.name = name;
		this.value = value;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return String.format("Operand [oper=%s, name=%s, value=%s]", oper, name, value);
	}
	
}

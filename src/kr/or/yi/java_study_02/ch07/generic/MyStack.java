package kr.or.yi.java_study_02.ch07.generic;

import java.util.Arrays;

public class MyStack {
	private int top;
	private int size;
	private String[] stack;
	public MyStack() {
		this.top = -1;
		size = 5;
		stack = new String[size];
	}
	public void push(String item) {
		if(!isFull()) {
			stack[++top]=item;
		}
	}
	
	public boolean isFull() {
		return top == this.size-1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void prnStack() {
		System.out.println(Arrays.toString(stack));
	}
	public String pop() {
		if(!isEmpty()) {
			return stack[top--];
		}
		return null;
	}
}

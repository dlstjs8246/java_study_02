package kr.or.yi.java_study_02.ch07.tranningEx;

import java.util.Vector;

public class MyStack<T> implements IStack<T> {
	private Vector<T> stack;
	private int top;
	public MyStack() {
		stack = new Vector<T>();
		top = -1;
	}

	public T pop() {
		if(top==-1) {
			return null;
		}
		return stack.get(top--);
	}

	@Override
	public boolean push(T ob) {
		stack.add(ob);
		top++;
		return top==10;
	}

}

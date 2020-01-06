package kr.or.yi.java_study_02.ch07;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList arr = new ArrayList(); //ArrayList<Object> arr = new ArrayList<>();
		ArrayList<Integer> arList = new ArrayList<>();
		addList(arList);
		arList.add(5);
		arList.add(3);
		arList.add(4);
		arList.add(1);
		for(int i=0;i<arList.size();i++) {
			int a = arList.get(i);
			System.out.println(a);
		}
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("이상원");
		strList.add("황태원");
		strList.add("권수진");
		strList.add("이상원");
		
		for(String s : strList) {
			System.out.println(s);
		}
		
		if(strList.contains("황태원")) {
			System.out.println("포함");
		}
		else {
			System.out.println("미포함");
		}
		
		int findIdx = strList.lastIndexOf("이상원");
		System.out.println(findIdx);
		
		System.out.println(strList.isEmpty());
		strList.remove(findIdx);
		System.out.println(strList);
		
		String[] a = new String[strList.size()];
		System.out.println(Arrays.toString(a));
		strList.toArray(a);
		System.out.println(Arrays.toString(a));
		
		strList.clear();
		System.out.println(strList.isEmpty());
		System.out.println(strList);
		
		
	}

	private static void addList(ArrayList<Integer> arList) {
		System.out.println(arList.size());
		arList.add(5);
		System.out.println(arList.size());
		for(int i=0;i<10;i++) {
			arList.add(i);
		}
		System.out.println(arList);
		
		arList.add(1,10);
		System.out.println(arList);
		
		ArrayList<Integer> subList = new ArrayList<Integer>();
		subList.add(20);
		subList.add(21);
		subList.add(22);
		
		arList.addAll(subList);
		System.out.println(arList);
	}
}

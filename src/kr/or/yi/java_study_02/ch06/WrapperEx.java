package kr.or.yi.java_study_02.ch06;

public class WrapperEx {

	public static void main(String[] args) {
		Integer i = 31; //autoboxing
		Integer i2 = Integer.valueOf(31);
		Integer i3 = new Integer(31);
		Integer i4 = Integer.valueOf("31");
		System.out.printf("%d %d %d %d%n",i,i2,i3,i4);
		
		System.out.println(Integer.bitCount(10));//31을 2진수로 변환 후 1의 개수
		System.out.println(Integer.toHexString(31));
		System.out.println(Integer.toBinaryString(31));
		System.out.println(Integer.toOctalString(31));
		System.out.println("=======================");
		System.out.println(i2.floatValue());
		System.out.println(i2.doubleValue());
		String str = i2.toString();
		System.out.println(str);
		
		System.out.println("=======================");
		System.out.println(Character.toLowerCase('A'));
		char c1 = '4';
		char c2 = 'F';
		if(Character.isDigit(c1)) {
			System.out.println(c1 + "은 숫자");
		}
		if(Character.isAlphabetic(c2)) {
			System.out.println(c2 + "는 영문자");
		}
		System.out.println(Integer.parseInt("-123"));
		System.out.println(Integer.toHexString(28));
		System.out.println(Integer.toBinaryString(28));
		System.out.println(Integer.toOctalString(28));
		System.out.println(Integer.bitCount(28));
		
		Double d = Double.valueOf(3.14);
		System.out.println(d.toString());
		System.out.println(Double.parseDouble("3.14"));
		
		boolean b = (4>3);
		System.out.println(Boolean.toString(b));
		System.out.println(Boolean.parseBoolean("false"));
	}

}

package kr.or.yi.java_study_02.ch06;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam {

	public static void main(String[] args) {
		String[] productArr = {"A001,아메리카노", 
				"A002,카푸치노", 
				"A003,헤이즐넛",
				"A004,에스프레소",
				"B001,딸기쉐이크",
				"B002,후르츠와인",
				"B003,팥빙수", 
				"B004,아이스초코"};
		
		String[] saleArr = {
				"1,A001,4500,150,10", 
				"2,A002,3800,140,15", 
				"3,B001,5200,250,12", 
				"4,B001,4300,110,11",
				};
		//위의 문장을 이용하여 Product클래스와 Sale클래스를 정의하고 
		//Product[] pdtArrs와 Sale[] saleArrs로 변경하시오.
		Product[] pdtArrs = convert_to_Product(productArr);
		prnArr(pdtArrs);
		
		Sale[] saleArrs = convert_to_Sale(saleArr);
		prnArr(saleArrs);
		
	}

	private static void prnArr(Sale[] saleArrs) {
		System.out.println("===Sale Class===");
		for(Sale s : saleArrs) {
			System.out.println(s);
		}
	}

	private static void prnArr(Product[] pdtArrs) {
		System.out.println("===Product Class===");
		for(Product p : pdtArrs) {
			System.out.println(p);
		}
	}

	private static Sale[] convert_to_Sale(String[] saleArr) {
		Sale[] sale = new Sale[saleArr.length];
		for(int i=0;i<saleArr.length;i++) {
			sale[i] = new Sale();
			StringTokenizer st = new StringTokenizer(saleArr[i],",");
			sale[i].setNo(Integer.parseInt(st.nextToken()));
			sale[i].setName(st.nextToken());
			sale[i].setPrice(Integer.parseInt(st.nextToken()));
			sale[i].setSaleCnt(Integer.parseInt(st.nextToken()));
			sale[i].setMarginRate(Integer.parseInt(st.nextToken()));
		}
		return sale;
	}

	private static Product[] convert_to_Product(String[] productArr) {
		Product[] product = new Product[productArr.length];
		for(int i=0;i<productArr.length;i++) {
			product[i] = new Product();
			StringTokenizer st = new StringTokenizer(productArr[i],",");
			product[i].setCode(st.nextToken());
			product[i].setName(st.nextToken());
		}
		return product;
	}

}

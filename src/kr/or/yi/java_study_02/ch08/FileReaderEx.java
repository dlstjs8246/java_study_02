package kr.or.yi.java_study_02.ch08;

import java.io.*;


public class FileReaderEx {
	public static void main(String[] args) throws FileNotFoundException   {
//		readEx01();
//		readEx02();
					
//		readFile("department.txt");
//		readFile("employee.txt");
		
//		readFileInputStream("department.txt");
	}

	private static void readFileInputStream(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\data\\" + fileName;
		File file = new File(filePath);
		try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8")) {
			int c;
			while((c= isr.read())!=-1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void readFile(String fileName) throws FileNotFoundException {
		String filePath = System.getProperty("user.dir") + "\\data\\" + fileName;
		File file = new File(filePath);
		
		//try-catch-resource => 자동으로 close호출. closable interface를 구현한 클래스만 가능
		try(FileReader fr = new FileReader(file)) {
			System.out.println("Encording : " + fr.getEncoding());
			char[] buf = new char[1024];
			while((fr.read(buf))!=-1) {
				System.out.print(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readEx02() throws FileNotFoundException, IOException {
		FileReader fn = new FileReader("C:\\Windows\\system.ini");
		int c;
		while((c = fn.read())!=-1) {
			System.out.print((char)c);
		}
		fn.close();
	}

	private static void readEx01() {
		FileReader fn = null;
		try {
			fn = new FileReader("C:\\Windows\\system.ini");
			int c;
			while((c = fn.read())!=-1) {
				System.out.print((char)c);
			}
			fn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

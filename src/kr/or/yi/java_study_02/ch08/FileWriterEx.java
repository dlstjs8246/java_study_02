package kr.or.yi.java_study_02.ch08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
	public static void main(String[] args) {
//		writer01();
		file_copy("department.txt","copy_department.txt");
	}

	private static void file_copy(String src, String dest) {
		String filePath = System.getProperty("user.dir") + "\\data\\";
		try(FileReader fr = new FileReader(filePath + src);
				FileWriter fw = new FileWriter(filePath + dest)){
			long start = System.nanoTime();
			char [] buf = new char[2048];
			while(fr.read(buf)!=-1) {
				fw.write(buf);
			}
			long end = System.nanoTime();
			System.out.println("걸린시간 : " + (double)(end-start)/1000000 + "ms");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writer01() {
		Scanner sc = new Scanner(System.in);
		String filePath = System.getProperty("user.dir") + "\\data\\test.txt";
		try(FileWriter fw = new FileWriter(filePath)) {
			while(true) {
				String line = sc.nextLine();
				if(line.length()==0) {
					break;
				}
				fw.write(line);
				fw.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}

package kr.or.yi.java_study_02.ch08;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class BufferedIOEx {
	public static void main(String[] args) {
		file_read_write("test.txt");
	}

	private static void file_read_write(String fileName) {
		Scanner sc = new Scanner(System.in);
		String filePath = System.getProperty("user.dir") + "\\data\\";
		try(FileWriter fw = new FileWriter(filePath + fileName);
				FileReader fd = new FileReader(filePath + fileName);
				BufferedOutputStream br = new BufferedOutputStream(System.out,5)) {
			while(true) {
				String line = sc.nextLine();
				if(line.length()==0) {
					break;
				}
				fw.write(line);
			}
			fw.close();
			int c;
			while((c=fd.read())!=-1) {
				br.write(c);
			}
			sc.nextLine();
			br.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	}
}

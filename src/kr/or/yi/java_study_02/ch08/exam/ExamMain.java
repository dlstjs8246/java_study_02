package kr.or.yi.java_study_02.ch08.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExamMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		exam01("c:\\Temp\\phone.txt",sc);
//		exam02("c:\\Temp\\phone.txt");
//		exam03("c:\\windows\\system.ini");
//		exam04("c:\\windows\\system.ini");
//	    exam05(sc);
//		exam06(sc);
//		exam07("화면캡쳐.png","화면캡쳐_copy.png");
//		exam08();
//		exam09();
//		exam10(sc);
//		exam11(sc);
//		exam12(sc);
		exam13(sc);
	}

	private static void exam13(Scanner sc) {
		File searcher = new File("c:\\");
		System.out.println("***** 파일 탐색기입니다. *****");
		while(true) {
			System.out.printf("\t[%s]%n",searcher.getPath());
			int i=0;
			for(File f : searcher.listFiles()) {
				if(i>4) {
					System.out.println("--------------- 생략하였습니다. ----------------");
					break;
				}
				if(f.isDirectory()) {
					System.out.printf("dir\t%s바이트\t%s%n",f.length(),f.getName());
					i++;
				}
				if(f.isFile()) {
					System.out.printf("file\t%s바이트\t%s%n",f.length(),f.getName());
					i++;
				}
			}
			System.out.print(searcher.getPath() + ">");
			
			String oper = sc.next();
			if(oper.equals("exit")) {
				break;
			}
			if(oper.equals("..")) {
				if(!searcher.getPath().equals("c:\\")) {
					String[] findRoot = searcher.getPath().split("\\\\");
					String prevPath = "";
					for(i=0;i<findRoot.length-1;i++) {
						prevPath += i == findRoot.length-1?(findRoot[i]):(findRoot[i] + "\\");
					}
					searcher = new File(prevPath);
				}
			}
			else {
				searcher = new File(searcher.getPath() + "\\" + oper);
			}
		}
	}

	private static void exam12(Scanner sc) {
		ArrayList<String> javaFile = new ArrayList<String>();
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력 >> ");
		String workspace = System.getProperty("user.dir") + "\\src\\kr\\or\\yi\\java_study_02\\ch08\\";
		String fileName = sc.next();
		int cnt = 0;
		try(Scanner scanner = new Scanner(new FileReader(workspace + fileName))) {
			while(scanner.hasNext()) {
				String line = ++cnt + ": " + scanner.nextLine();
				javaFile.add(line);
			}
			cnt = 0;
			while(true) {
				System.out.print("검색할 단어나 문장>> ");
				String val = sc.next();
				if(val.equals("그만")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				for(String s : javaFile) {
					if(s.indexOf(val)>-1) {
						System.out.println(s);
						cnt++;
					}
				}
				if(cnt==0) {
					System.out.println("그런 단어나 문장이 없습니다.");
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void exam11(Scanner sc) {
		try(FileReader fr = new FileReader(System.getProperty("user.dir") + "\\data\\words.txt")) {
			ArrayList<String> words = new ArrayList<>();
			char[] buf = new char[1024];
			while(fr.read(buf)!=-1);
			StringBuffer sb = new StringBuffer();
			sb.append(buf);
			String val = new String(sb);
			String[] vals = val.split(",");
			for(int i=0;i<vals.length;i++) {
				words.add(vals[i]);
			}
			System.out.println(System.getProperty("user.dir") + "\\data\\words.txt를 읽었습니다..");
			while(true) {
				System.out.print("단어 >> ");
				val = sc.nextLine();
				if(val.equals("그만")) {
					System.out.println("종료합니다...");
					break;
				}
				for(String s : words) {
					if(s.indexOf(val)>-1) {
						System.out.println(s);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exam10(Scanner sc) {
		try(FileReader fr = new FileReader("c:\\Temp\\phone.txt")) {
			HashMap<String,String> phone = new HashMap<>();
			StringBuffer value = new StringBuffer();
			int c;
			while((c=fr.read())!=-1) {
				value.append((char)c);
			}
			String data = new String(value);
			String[] values = data.split("\\s");
			for(int i=0;i<values.length;i=i+2) {
				phone.put(values[i], values[i+1]);
			}
			System.out.println("총 " + phone.size() + "개의 전화번호를 읽었습니다.");
			while(true) {
				System.out.print("이름>> ");
				String val = sc.next();
				if(val.equals("그만")) {
					break;
				}
				if(phone.containsKey(val)) {
					System.out.println(phone.get(val));
				}
				else {
					System.out.println("찾는 이름이 없습니다.");
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void exam09() {
		File temp = new File("c:\\Temp");
		File[] tempFiles = temp.listFiles();
		System.out.println("temp디렉터리의 .txt 파일을 모두 삭제합니다...");
		int cnt = 0;
		for(int i=0;i<tempFiles.length;i++) {
			if(tempFiles[i].getPath().indexOf(".txt")>-1) {
				System.out.println(tempFiles[i].getPath() + "삭제");
				tempFiles[i].delete();
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("삭제할 파일이 존재하지 않습니다.");
		}
	}

	private static void exam08() {
		File c = new File("c:\\");
		File[] cFiles = c.listFiles();
		long max = Long.MIN_VALUE;
		for(int i=0;i<cFiles.length;i++) {
			if(max<cFiles[i].length()) {
				max = cFiles[i].length();
			}
		}
		for(int i=0;i<cFiles.length;i++) {
			if(cFiles[i].length()==max) {
				System.out.println("가장 큰 파일은 " + cFiles[i].getPath() + " " + cFiles[i].length() + "byte");
				break;
			}
			continue;
		}
	}

	private static void exam07(String src, String desc) {
		System.out.println(src +"를 " + desc + "로 복사합니다.");
		String path = System.getProperty("user.dir") + "\\data\\";
		try(FileInputStream fis = new FileInputStream(path+src);
				FileOutputStream fos = new FileOutputStream(path+desc)) {
			byte[] buf = new byte[2048];
			System.out.println("10%마다 *를 출력합니다.");
			long start = System.nanoTime();
			while(fis.read(buf)!=-1) {	
				fos.write(buf);
			}
			long end = System.nanoTime();
			double excuteTime = start - end;
			double sum = 0;
			while(excuteTime!=sum) {
				sum += excuteTime*0.1;
				System.out.print("*");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exam06(Scanner sc) {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트/Data 경로에 있어야 합니다.");
		String project = System.getProperty("user.dir") + "\\data\\";
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String file1 = sc.next();
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String file2 = sc.next();
		try(FileReader fr = new FileReader(project+file1);
				FileReader fr2 = new FileReader(project+file2);
				FileWriter fw = new FileWriter(project+"appended.txt")) {
			char [] buf = new char[1024];
			while(fr.read(buf)!=-1) {
				fw.write(buf);
			}
			buf = new char[1024];
			while(fr2.read(buf)!=-1) {
				fw.write(buf);
			}
			System.out.println("프로젝트/data 경로에 appended.txt 파일에 저장하였습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exam05(Scanner sc) {
		//파일의 내용을 비교할때는 binary로 같은지 비교해야 한다.
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트/Data 경로에 있어야 합니다.");
		String project = System.getProperty("user.dir") + "\\data\\";
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String file1 = sc.next();
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String file2 = sc.next();
		System.out.println(file1 + "와 " + file2 + "를 비교합니다.");
		try(FileInputStream fis = new FileInputStream(project+file1);
				FileInputStream fis2 = new FileInputStream(project+file2)) {
			int b1;
			int b2;
			while((b1=fis.read())!=-1) {
				b2=fis.read();
				if((byte)b1!=(byte)b2) {
						break;
				}
			}
			System.out.println("파일이 같습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
		
	

	private static void exam04(String file) {
		int i = 0;
		System.out.println(file + " 파일을 읽어 출력합니다.");
		try(Scanner fScanner = new Scanner(new FileReader(file))) {
			while(fScanner.hasNext()) {
				String line = fScanner.nextLine();
				System.out.printf("%4d:%s%n",++i,line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

	private static void exam03(String path) {
		try(FileReader fr = new FileReader(path)) {
			int c;
			while((c=fr.read())!=-1) {
				System.out.print(Character.toUpperCase((char)c));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void exam02(String path) {
		System.out.println(path + "를 출력합니다.");
		try(FileReader fr = new FileReader(path)) {
			char[] buf = new char[1024];
			while((fr.read(buf))!=-1) {
				System.out.print(buf);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exam01(String path,Scanner sc) {
		try(FileWriter fw = new FileWriter(path)) {
			System.out.println("전화번호 입력 프로그램입니다.");
			String val = "";
			while(true) {
				System.out.print("이름, 전화번호 >> ");
				val = sc.nextLine();
				if(val.equals("그만")) {
					break;
				}
				fw.write(val);
				fw.write("\t\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

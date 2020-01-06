package kr.or.yi.java_study_02.ch07.tranningEx;

import java.util.*;

public class ExamMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		exam01(sc);
//		exam02(sc);
//		exam03(sc);
//		exam04(sc);
//		exam05_1(sc);
//		exam05_2(sc);
//		exam06(sc);
//		exam07(sc);
//		exam08(sc);
//		exam09();
//		exam10(sc);
//		exam11_1(sc);
//		exam11_2(sc);
//		exam12(sc);
//		exam13(sc);
		sc.close();
	}

	private static void exam13(Scanner sc) {
		Vector<Operand> comOper = new Vector<Operand>();
		HashMap<String,Integer> valueMap = new HashMap<String, Integer>();
		System.out.println("�������� �۵��մϴ�. ���α׷��� �Է��� �ּ���. go�� �Է��ϸ� �۵��մϴ�.");
		String oper = "";
		String name = "";
		String value = "";
		while(true) {
			System.out.print(">> ");
			oper = sc.next().trim();
			if(oper.equals("go")) {
				break;
			}
			name = sc.next().trim();
			value = sc.next();
			comOper.add(new Operand(oper,name,value));
		}
		for(int i=0;i<comOper.size();i++) {
			switch(comOper.get(i).getOper()) {
			case "mov":
				valueMap.put(comOper.get(i).getName(), Integer.parseInt(comOper.get(i).getValue()));
				break;
			case "add":
				int cnt = 0;
				Set <String> keys = valueMap.keySet();
				Iterator<String> it = keys.iterator();
				while(it.hasNext()) {
					String key = it.next();
					if(key.equals(comOper.get(i).getValue())) {
						valueMap.put(comOper.get(i).getName(), valueMap.get(comOper.get(i).getName())+valueMap.get(comOper.get(i).getValue()));
						cnt++;
						break;
					}
				}
				if(cnt==0) {
					valueMap.put(comOper.get(i).getName(), valueMap.get(comOper.get(i).getName())+Integer.parseInt(comOper.get(i).getValue()));
					break;
				}
				break;
			case "sub":
				cnt = 0;
				keys = valueMap.keySet();
				it = keys.iterator();
				while(it.hasNext()) {
					String key = it.next();
					if(key.equals(comOper.get(i).getValue())) {
						valueMap.put(comOper.get(i).getName(), valueMap.get(comOper.get(i).getName())-valueMap.get(comOper.get(i).getValue()));
						cnt++;
						break;
					}
				}
				if(cnt==0) {
					valueMap.put(comOper.get(i).getName(), valueMap.get(comOper.get(i).getName())-Integer.parseInt(comOper.get(i).getValue()));
					break;
				}
				break;
			case "jn0":
				while(valueMap.get(comOper.get(i).getName())!=0) {
					i=Integer.parseInt(comOper.get(i).getValue())-1;
					break;
				}
				break;
			case "prt":
				System.out.println("[" + comOper.get(0).getOper() + " " + comOper.get(0).getName() + " " + comOper.get(0).getValue() + "]");
				for(int j=0;j<comOper.size();j++) {
					if(comOper.get(j).getOper().equals("mov")) {
						System.out.print(comOper.get(j).getName().toUpperCase() +":" + valueMap.get(comOper.get(j).getName()) + " ");
					}
					else {
						continue;
					}
				}
				System.out.println();
				System.out.println("����� ����� " + valueMap.get(comOper.get(0).getName()) + " ���α׷� ���� ��");
				break;
			}
		}	
	}

	private static void exam12(Scanner sc) {
		HashMap<String,String> voca = initVoca();
		System.out.println("***** ���� �ܾ� �׽�Ʈ ���α׷� \"��ǰ����\"�Դϴ�. *****");
		while(true) {
			System.out.print("�ܾ� �׽�Ʈ:1 �ܾ� ����:2 ����:3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("���� " + voca.size() + "���� �ܾ ��� �ֽ��ϴ�. -1�� �Է��ϸ� �׽�Ʈ�� �ߴ��մϴ�.");
				while(true) {
					Set<String> keys = voca.keySet();
					String[] keyArr = new String[keys.size()];
					Iterator<String> it = keys.iterator();
					for(int i=0;i<keyArr.length;i++) {
						if(it.hasNext()) {
							keyArr[i] = it.next();
						}
					}
					int[] rndArr = new int[4];
					for(int i=0;i<rndArr.length;i++) {
						rndArr[i] = (int)(Math.random() * keyArr.length);
						for(int j=0;j<i;j++) {
							if(rndArr[i]==rndArr[j]) {
								i--;
							}
						}
					}
					int rnd = (int)(Math.random() * rndArr.length);
					System.out.println(keyArr[rndArr[rnd]] + "?");
					for(int i=0;i<rndArr.length;i++) {
						System.out.print("(" + (i+1) + ")" + voca.get(keyArr[rndArr[i]]) + " ");
					}
					System.out.print(":>");
					int answer = sc.nextInt();
					if(answer==-1) {
						break;
					}
					if(voca.get(keyArr[rndArr[answer-1]])==voca.get(keyArr[rndArr[rnd]])) {
						System.out.println("Excellent !!");
					}
					else {
						System.out.println("no !!");
					}
				}
			break;
			case 2:
				System.out.println("���� �ܾ �׸��� �Է��ϸ� �Է��� �����մϴ�.");
				while(true) {
					System.out.print("���� �ѱ� �Է�>> ");
					String eng = sc.next();
					if(eng.equals("�׸�")) {
						break;
					}
					String kor = sc.next();
					voca.put(eng, kor);
				}
			break;
			case 3:
				System.out.println("\"��ǰ����\"�� �����մϴ�.");
				return;
			}
		}
	}

	private static HashMap<String, String> initVoca() {
		HashMap<String,String> voca = new HashMap<String, String>();
		voca.put("eye", "��");
		voca.put("nose", "��");
		voca.put("mouse", "��");
		voca.put("throat", "��");
		voca.put("demension", "����");
		voca.put("strawberry", "����");
		voca.put("banana", "�ٳ���");
		voca.put("melon", "���");
		voca.put("watermelon", "����");
		voca.put("springonion", "��");
		voca.put("opening", "����");
		voca.put("object", "��ü");
		voca.put("development", "����");
		voca.put("planning", "��ȹ");
		voca.put("victory", "�¸�");
		voca.put("grit", "����");
		voca.put("society", "��ȸ");
		return voca;
	}

	private static void exam11_2(Scanner sc) {
		HashMap<String,String> nation = initNationHashMap();
		int input = nation.size();
		System.out.println("******** ���� ���߱� ������ �����մϴ�. *********");
		while(true) {
			System.out.print("�Է� :1, ����:2, ���� :3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("���� " + input + "���� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
				while(true) {
					System.out.print("����� ���� �Է�" + ++input +">> ");
					String country = sc.next();
					if(country.equals("�׸�")) {
						break;
					}
					String captical = sc.next();
					nation.put(country,captical);
				}
				break;
			case 2:
				while(true) {
					int size = 0;
					Set <String> keys = nation.keySet();
					String[] keyArr = new String[keys.size()];
					Iterator<String> it = keys.iterator();
					while(it.hasNext()) {
						keyArr[size++] = it.next();
					}
					int rnd = (int)(Math.random()*nation.size());
					System.out.print(keyArr[rnd] + "�� ������? ");
					String captical = sc.next();
					if(captical.equals("�׸�")) {
						break;
					}
					if(nation.containsValue(captical)) {
						System.out.println("����!!");
					}
					else {
						System.out.println("�ƴմϴ�!!");
					}
				}
				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				return;
			}	
		}
	}

	private static HashMap<String, String> initNationHashMap() {
		HashMap<String,String> nation = new HashMap<String, String>();
		nation.put("�ѱ�","����");
		nation.put("�Ϻ�","����");
		nation.put("�߱�","����¡");
		nation.put("�����","���������");
		nation.put("�����","�����");
		nation.put("������","�ĸ�");
		nation.put("������","����");
		nation.put("����","������");
		nation.put("����","����");
		return nation;
	}

	private static void exam11_1(Scanner sc) {
		Vector<Nation> nation = initNation();
		int input = nation.size();
		System.out.println("******** ���� ���߱� ������ �����մϴ�. *********");
		while(true) {
			System.out.print("�Է� :1, ����:2, ���� :3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("���� " + input + "���� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
				while(true) {
					System.out.print("����� ���� �Է�" + ++input +">> ");
					String country = sc.next();
					if(country.equals("�׸�")) {
						break;
					}
					String captical = sc.next();
					nation.add(new Nation(country,captical));
				}
				break;
			case 2:
				while(true) {
					int rnd = (int)(Math.random()*nation.size());
					System.out.print(nation.get(rnd).getCountry() + "�� ������? ");
					String captical = sc.next();
					if(captical.equals("�׸�")) {
						break;
					}
					Nation checkNation = new Nation(captical);
					if(nation.contains(checkNation)) {
						System.out.println("����!!");
					}
					else {
						System.out.println("�ƴմϴ�!!");
					}
				}
				break;
			case 3:
				System.out.println("������ �����մϴ�.");
				return;
			}	
		}
	}

	private static Vector<Nation> initNation() {
		Vector<Nation> init = new Vector<Nation>();
		init.add(new Nation("�ѱ�","����"));
		init.add(new Nation("�Ϻ�","����"));
		init.add(new Nation("�߱�","����¡"));
		init.add(new Nation("����","������丣"));
		init.add(new Nation("���þ�","��ũ��"));
		init.add(new Nation("�븸","Ÿ������"));
		init.add(new Nation("�ʸ���","���Ҷ�"));
		init.add(new Nation("�±�","����"));
		init.add(new Nation("��Ʈ��","�ϳ���"));
		return init;
	}

	private static void exam10(Scanner sc) {
		Vector<Shape> shape = new Vector<Shape>();
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		while(true) {
			System.out.print("����(1), ����(2), ��� ����(3), ����(4)>> ");
			switch(sc.nextInt()) {
			case 1:
				insertShape(shape,sc);
				break;
			case 2:
				deleteShape(shape,sc);
				break;
			case 3:
				showShape(shape);
				break;
			case 4:
				System.out.println("beauty�� �����մϴ�.");
				return;
			}
		}
	}

	private static void showShape(Vector<Shape> shape) {
		for(Shape s : shape) {
			s.draw();
		}
	}

	private static void deleteShape(Vector<Shape> shape, Scanner sc) {
		System.out.print("������ ������ ��ġ>> ");
		shape.remove(sc.nextInt());
	}

	private static void insertShape(Vector<Shape> shape, Scanner sc) {
		System.out.print("Line(1), Rect(2), Circle(3)>> ");
		switch(sc.nextInt()) {
		case 1:
			shape.add(new Line());
			break;
		case 2:
			shape.add(new Rect());
			break;
		case 3:
			shape.add(new Circle());
			break;
		}
	}

	private static void exam09() {
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<10;i++) stack.push(i);
		while(true) {
			Integer n = stack.pop();
			if(n == null) break;
			System.out.print(n + " ");
		}
	}

	private static void exam08(Scanner sc) {
		HashMap<String,Integer> point = new HashMap<String, Integer>();
		System.out.println("** ����Ʈ ���� ���α׷��Դϴ�. **");
		String name = "";
		int sum = 0;
		while(true) {
			System.out.print("�̸��� ����Ʈ �Է� >> ");
			name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			int p = sc.nextInt();
			if(point.containsKey(name)) {
				int p2 = point.get(name);
				p += p2;
			}
			point.put(name, p);
			Set <String> keys = point.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String key = it.next();
				System.out.print("(" + key + "," + point.get(key) + ")");
			}
			System.out.println();
		}
	}

	private static void exam07(Scanner sc) {
		HashMap<String,Double> scholerShip = new HashMap<String, Double>();
		System.out.println("�̷����бݰ����ý����Դϴ�.");
		for(int i=0;i<5;i++) {
			System.out.print("�̸��� ���� >>");
			String name = sc.next();
			double score = sc.nextDouble();
			scholerShip.put(name,score);
		}
		System.out.print("���л� ���� ���� ���� �Է� >> ");
		double standard = sc.nextDouble();
		Set <String> keys = scholerShip.keySet();
		Iterator<String> it = keys.iterator();
		System.out.print("���л� ��� : ");
		while(it.hasNext()) {
			String key = it.next();
			if(scholerShip.get(key)>standard) {
				System.out.print(key + " ");
			}
		}
	}

	private static void exam06(Scanner sc) {
		HashMap<String,Location> location = new HashMap<String, Location>();
		System.out.println("����,�浵,������ �Է��ϼ���");
		int cnt = 0;
		while(cnt<4) {
			System.out.print(">> ");
			String data = sc.nextLine();
			String[] dataArr = data.split(",");
			String city = dataArr[0].trim();
			int longitude = Integer.parseInt(dataArr[1].trim());
			int ratitude = Integer.parseInt(dataArr[2].trim());
			Location loc = new Location(city, longitude, ratitude);
			location.put(city, loc);
			cnt++;
		}
		Set <String> keys = location.keySet();
		String[] keyArr = new String[keys.size()];
		Iterator<String> it = keys.iterator();
		System.out.println("-------------------------");
		for(int i=0;i<keys.size();i++) {
			if(it.hasNext()) {
				keyArr[i] = it.next();
				System.out.println(location.get(keyArr[i]));
			}
		}
		System.out.println("-------------------------");
		String res = "";
		while(!res.equals("�׸�")) {
			System.out.print("���� �̸� >> ");
			res = sc.next();
			if(location.containsKey(res)) {
				System.out.println(location.get(res));
			}
			else {
				System.out.println(res + "�� �����ϴ�.");
			}
		}
	}

	private static void exam05_2(Scanner sc) {
		StudentMgnByHashMap sm = new StudentMgnByHashMap();
		HashMap<String,Student> student = new HashMap<String, Student>();
		System.out.println("�л� �̸�,�а�,�й�,��������� �Է��ϼ���.");
		for(int i=0;i<4;i++) {
			System.out.print(">> ");
			String val = sc.next();
			String[] stdInfo = val.split(",");
			String name = stdInfo[0].trim();
			String deptName = stdInfo[1].trim();
			int deptNo = Integer.parseInt(stdInfo[2].trim());
			double scoreAvg = Double.parseDouble(stdInfo[3].trim());
			student.put(name, new Student(name,deptName,deptNo,scoreAvg));
			sm.insertStdMap(student);
		}
		sm.prnStdMap();
		while(true) {
			System.out.print("�л� �̸� >> ");
			String name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			HashMap<String,Student> serachHash = new HashMap<String, Student>();
			serachHash.put(name,new Student());
			sm.searchStdMap(serachHash);
		}
	}

	private static void exam05_1(Scanner sc) {
		StudentMgnByArrayList sm = new StudentMgnByArrayList();
		System.out.println("�л� �̸�,�а�,�й�,��������� �Է��ϼ���.");
		for(int i=0;i<4;i++) {
			System.out.print(">> ");
			String val = sc.next();
			String[] stdInfo = val.split(",");
			String name = stdInfo[0].trim();
			String deptName = stdInfo[1].trim();
			int deptNo = Integer.parseInt(stdInfo[2].trim());
			double scoreAvg = Double.parseDouble(stdInfo[3].trim());
			sm.insertStd(new Student(name, deptName, deptNo, scoreAvg));
		}
		sm.prnStd();
		while(true) {
			System.out.print("�л� �̸� >> ");
			String name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			sm.findStd(new Student(name));
		}
	}

	private static void exam04(Scanner sc) {
		Vector<Integer> rain = new Vector<Integer>();
		int val;
		do {
			int sum = 0;
			System.out.print("������ �Է� (0 �Է½� ����)>> ");
			val = sc.nextInt();
			if(val==0) {
				break;
			}
			rain.add(val);
			if(!rain.isEmpty()) {
				for(int i : rain) {
					System.out.print(i + " ");
					sum += i;
				}
				System.out.println();
				System.out.println("���� ��� : " + sum/rain.size());
			}
		}while(true);
	}

	private static void exam03(Scanner sc) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		String name;
		int pop;
		System.out.println("���� �̸��� �α��� �Է��ϼ���.(��: Korea 5000)");
		do {
			System.out.print("���� �̸�, �α� >> ");
			name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			pop = sc.nextInt();
			nations.put(name, pop);
		}while(true);
		do {
			System.out.print("�α� �˻� >> ");
			name = sc.next();
			if(name.equals("�׸�")) {
				break;
			}
			Set <String> keys = nations.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				if(nations.get(name)==null) {
					System.out.println(name + "(��)��� ����� �����ϴ�.");
					break;
				}
				else {
					System.out.println(name + "�� �α��� " + nations.get(name));
					break;
				}
			}
		}while(true);
	}

	private static void exam02(Scanner sc) {
		ArrayList<String> rank = new ArrayList<String>();
		ArrayList<Double> score = new ArrayList<Double>();
		double sum = 0.0;
		System.out.print("6�� ������ �� ĭ���� �и� �Է�(A/B/C/D/E/F)>>");
		for(int i=0;i<6;i++) {
			rank.add(sc.next());
			switch(rank.get(i)) {
			case "A":
				score.add(4.0);
				sum += score.get(i);
				break;
			case "B":
				score.add(3.0);
				sum += score.get(i);
				break;
			case "C":
				score.add(2.0);
				sum += score.get(i);
				break;
			case "D":
				score.add(1.0);
				sum += score.get(i);
				break;
			case "F":
				score.add(0.0);
				sum += score.get(i);
				break;
			}
		}
		System.out.println(sum/score.size());
	}

	private static void exam01(Scanner sc) {
		Vector<Integer> vc = new Vector<>();
		System.out.print("����(-1�� �Էµ� ������)>> ");
		int value = 0;
		int max = Integer.MIN_VALUE;
		while(value!=-1) {
			value = sc.nextInt();
			vc.add(value);
			for(int i=0;i<vc.size();i++) {
				if(max<vc.get(i)) {
					max = vc.get(i);
				}
			}
		}
		System.out.println("���� ū���� " + max);
	}

}

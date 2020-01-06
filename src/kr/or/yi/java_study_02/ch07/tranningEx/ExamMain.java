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
		System.out.println("슈퍼컴이 작동합니다. 프로그램을 입력해 주세요. go를 입력하면 작동합니다.");
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
				System.out.println("출력할 결과는 " + valueMap.get(comOper.get(0).getName()) + " 프로그램 실행 끝");
				break;
			}
		}	
	}

	private static void exam12(Scanner sc) {
		HashMap<String,String> voca = initVoca();
		System.out.println("***** 영어 단어 테스트 프로그램 \"명품영어\"입니다. *****");
		while(true) {
			System.out.print("단어 테스트:1 단어 삽입:2 종료:3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("현재 " + voca.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 중단합니다.");
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
				System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
				while(true) {
					System.out.print("영어 한글 입력>> ");
					String eng = sc.next();
					if(eng.equals("그만")) {
						break;
					}
					String kor = sc.next();
					voca.put(eng, kor);
				}
			break;
			case 3:
				System.out.println("\"명품영어\"를 종료합니다.");
				return;
			}
		}
	}

	private static HashMap<String, String> initVoca() {
		HashMap<String,String> voca = new HashMap<String, String>();
		voca.put("eye", "눈");
		voca.put("nose", "코");
		voca.put("mouse", "입");
		voca.put("throat", "목");
		voca.put("demension", "차원");
		voca.put("strawberry", "딸기");
		voca.put("banana", "바나나");
		voca.put("melon", "멜론");
		voca.put("watermelon", "수박");
		voca.put("springonion", "파");
		voca.put("opening", "공석");
		voca.put("object", "객체");
		voca.put("development", "개발");
		voca.put("planning", "기획");
		voca.put("victory", "승리");
		voca.put("grit", "끈기");
		voca.put("society", "사회");
		return voca;
	}

	private static void exam11_2(Scanner sc) {
		HashMap<String,String> nation = initNationHashMap();
		int input = nation.size();
		System.out.println("******** 수도 맞추기 게임을 시작합니다. *********");
		while(true) {
			System.out.print("입력 :1, 퀴즈:2, 종료 :3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("현재 " + input + "개의 나라와 수도가 입력되어 있습니다.");
				while(true) {
					System.out.print("나라와 수도 입력" + ++input +">> ");
					String country = sc.next();
					if(country.equals("그만")) {
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
					System.out.print(keyArr[rnd] + "의 수도는? ");
					String captical = sc.next();
					if(captical.equals("그만")) {
						break;
					}
					if(nation.containsValue(captical)) {
						System.out.println("정답!!");
					}
					else {
						System.out.println("아닙니다!!");
					}
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				return;
			}	
		}
	}

	private static HashMap<String, String> initNationHashMap() {
		HashMap<String,String> nation = new HashMap<String, String>();
		nation.put("한국","서울");
		nation.put("일본","도쿄");
		nation.put("중국","베이징");
		nation.put("브라질","브라질리아");
		nation.put("몰디브","몰디브");
		nation.put("프랑스","파리");
		nation.put("스위스","베른");
		nation.put("독일","베를린");
		nation.put("영국","런던");
		return nation;
	}

	private static void exam11_1(Scanner sc) {
		Vector<Nation> nation = initNation();
		int input = nation.size();
		System.out.println("******** 수도 맞추기 게임을 시작합니다. *********");
		while(true) {
			System.out.print("입력 :1, 퀴즈:2, 종료 :3>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("현재 " + input + "개의 나라와 수도가 입력되어 있습니다.");
				while(true) {
					System.out.print("나라와 수도 입력" + ++input +">> ");
					String country = sc.next();
					if(country.equals("그만")) {
						break;
					}
					String captical = sc.next();
					nation.add(new Nation(country,captical));
				}
				break;
			case 2:
				while(true) {
					int rnd = (int)(Math.random()*nation.size());
					System.out.print(nation.get(rnd).getCountry() + "의 수도는? ");
					String captical = sc.next();
					if(captical.equals("그만")) {
						break;
					}
					Nation checkNation = new Nation(captical);
					if(nation.contains(checkNation)) {
						System.out.println("정답!!");
					}
					else {
						System.out.println("아닙니다!!");
					}
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				return;
			}	
		}
	}

	private static Vector<Nation> initNation() {
		Vector<Nation> init = new Vector<Nation>();
		init.add(new Nation("한국","서울"));
		init.add(new Nation("일본","도쿄"));
		init.add(new Nation("중국","베이징"));
		init.add(new Nation("몽골","울란바토르"));
		init.add(new Nation("러시아","모스크바"));
		init.add(new Nation("대만","타이페이"));
		init.add(new Nation("필리핀","마닐라"));
		init.add(new Nation("태국","방콕"));
		init.add(new Nation("베트남","하노이"));
		return init;
	}

	private static void exam10(Scanner sc) {
		Vector<Shape> shape = new Vector<Shape>();
		System.out.println("그래픽 에디터 beauty를 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>> ");
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
				System.out.println("beauty을 종료합니다.");
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
		System.out.print("삭제할 도형의 위치>> ");
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
		System.out.println("** 포인트 관리 프로그램입니다. **");
		String name = "";
		int sum = 0;
		while(true) {
			System.out.print("이름과 포인트 입력 >> ");
			name = sc.next();
			if(name.equals("그만")) {
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
		System.out.println("미래장학금관리시스템입니다.");
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점 >>");
			String name = sc.next();
			double score = sc.nextDouble();
			scholerShip.put(name,score);
		}
		System.out.print("장학생 선발 학점 기준 입력 >> ");
		double standard = sc.nextDouble();
		Set <String> keys = scholerShip.keySet();
		Iterator<String> it = keys.iterator();
		System.out.print("장학생 명단 : ");
		while(it.hasNext()) {
			String key = it.next();
			if(scholerShip.get(key)>standard) {
				System.out.print(key + " ");
			}
		}
	}

	private static void exam06(Scanner sc) {
		HashMap<String,Location> location = new HashMap<String, Location>();
		System.out.println("도시,경도,위도를 입력하세요");
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
		while(!res.equals("그만")) {
			System.out.print("도시 이름 >> ");
			res = sc.next();
			if(location.containsKey(res)) {
				System.out.println(location.get(res));
			}
			else {
				System.out.println(res + "는 없습니다.");
			}
		}
	}

	private static void exam05_2(Scanner sc) {
		StudentMgnByHashMap sm = new StudentMgnByHashMap();
		HashMap<String,Student> student = new HashMap<String, Student>();
		System.out.println("학생 이름,학과,학번,학점평균을 입력하세요.");
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
			System.out.print("학생 이름 >> ");
			String name = sc.next();
			if(name.equals("그만")) {
				break;
			}
			HashMap<String,Student> serachHash = new HashMap<String, Student>();
			serachHash.put(name,new Student());
			sm.searchStdMap(serachHash);
		}
	}

	private static void exam05_1(Scanner sc) {
		StudentMgnByArrayList sm = new StudentMgnByArrayList();
		System.out.println("학생 이름,학과,학번,학점평균을 입력하세요.");
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
			System.out.print("학생 이름 >> ");
			String name = sc.next();
			if(name.equals("그만")) {
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
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
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
				System.out.println("현재 평균 : " + sum/rain.size());
			}
		}while(true);
	}

	private static void exam03(Scanner sc) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		String name;
		int pop;
		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
		do {
			System.out.print("나라 이름, 인구 >> ");
			name = sc.next();
			if(name.equals("그만")) {
				break;
			}
			pop = sc.nextInt();
			nations.put(name, pop);
		}while(true);
		do {
			System.out.print("인구 검색 >> ");
			name = sc.next();
			if(name.equals("그만")) {
				break;
			}
			Set <String> keys = nations.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				if(nations.get(name)==null) {
					System.out.println(name + "(이)라는 나라는 없습니다.");
					break;
				}
				else {
					System.out.println(name + "의 인구는 " + nations.get(name));
					break;
				}
			}
		}while(true);
	}

	private static void exam02(Scanner sc) {
		ArrayList<String> rank = new ArrayList<String>();
		ArrayList<Double> score = new ArrayList<Double>();
		double sum = 0.0;
		System.out.print("6개 학점을 빈 칸으로 분리 입력(A/B/C/D/E/F)>>");
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
		System.out.print("정수(-1이 입력될 때까지)>> ");
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
		System.out.println("가장 큰수는 " + max);
	}

}

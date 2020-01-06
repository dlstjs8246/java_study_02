package kr.or.yi.java_study_02.ch06;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		printCalendar("����",now);
		
		Calendar firstDate = Calendar.getInstance();
		firstDate.clear();
		firstDate.set(2016,11,25);
		firstDate.set(Calendar.HOUR_OF_DAY,20);
		firstDate.set(Calendar.MINUTE, 30);
		printCalendar("ó�� ����Ʈ�� ���� ",firstDate);
		
	}

	private static void printCalendar(String string, Calendar now) {
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH) + 1;
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		int hour = now.get(Calendar.HOUR);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		int ampm = now.get(Calendar.AM_PM);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millisecond = now.get(Calendar.MILLISECOND);
		System.out.print(string + ": " + year + "/" + month + "/" + day + "/");
		
		switch(dayOfWeek) {
		case Calendar.SUNDAY : 
			System.out.print("�Ͽ���"); 
			break;
		case Calendar.MONDAY : 
			System.out.print("������"); 
			break;
		case Calendar.TUESDAY : 
			System.out.print("ȭ����"); 
			break;
		case Calendar.WEDNESDAY : 
			System.out.print("������"); 
			break;
		case Calendar.THURSDAY : 
			System.out.print("�����"); 
			break;
		case Calendar.FRIDAY : 
			System.out.print("�ݿ���"); 
			break;
		case Calendar.SATURDAY : 
			System.out.print("�����"); 
			break;
		}
		System.out.print("(" + hourOfDay + "��)");
		if(ampm == Calendar.AM) {
			System.out.print("����");
		}
		else {
			System.out.print("����");
		}
		System.out.println(hour + "��" + minute + "��" + second + "��" + millisecond + "�и���");
	}

}

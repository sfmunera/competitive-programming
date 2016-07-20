package codeforces;

import java.util.*;

public class TheTime {
	
	static String toTime(int minutes) {
		minutes %= (24 * 60);
		int hour = minutes / 60;
		int min = minutes % 60;
		
		return (hour < 10 ? "0" : "") + hour + ":" + (min < 10 ? "0" : "") + min; 
	}
	
	static int fromTime(String time) {
		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[1]);
		
		return hour * 60 + min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String time = in.next();
		int a = in.nextInt();
		
		System.out.println(toTime(fromTime(time) + a));
		
		in.close();
		System.exit(0);
	}
}

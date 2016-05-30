package codeforces;

import java.util.*;

public class AncientProphesy {
	
	static final int DATE_LEN = 10; // dd-mm-yyyy
	static final int[] DAYS_PER_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static boolean isValid(String date) {
		String[] parts = date.split("-");
		if (parts.length != 3) return false;
		if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) return false;
		int day = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		
		return year >= 2013 && year <= 2015 && month >= 1 && month <= 12 && day > 0 && day <= DAYS_PER_MONTH[month - 1];
	}
	
	static String solve(String prophesy) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		String apocalypseDate = "";
		count.put(apocalypseDate, 0);
		for (int i = 0; i + DATE_LEN <= prophesy.length(); ++i) {
			String candidate = prophesy.substring(i, i + DATE_LEN);
			if (isValid(candidate)) {
				if (!count.containsKey(candidate)) {
					count.put(candidate, 0);
				}
				count.put(candidate, count.get(candidate) + 1);
				if (count.get(candidate) > count.get(apocalypseDate)) {
					apocalypseDate = candidate;
				}
			}
		}
		
		return apocalypseDate;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String prophesy = in.next();
		System.out.println(solve(prophesy));
		
		in.close();
		System.exit(0);
	}
}

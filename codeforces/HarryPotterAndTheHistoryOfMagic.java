import java.util.*;

public class HarryPotterAndTheHistoryOfMagic {
	
	static boolean valid(int[] dates) {
		for (int i = 0; i < dates.length; i++) {
			if (dates[i] < 1000 || dates[i] > 2011) return false;
			if (i > 0 && dates[i - 1] > dates[i]) return false;
		}
		return true;
	}
	
	static int changeDate(int currentDate, int previousDate) {
		char[] dateChars = String.valueOf(currentDate).toCharArray();
		int min = 9999;
		for (int i = 0; i < dateChars.length; i++) {
			char tmp = dateChars[i];
			for (char c = '0'; c <= '9'; c++) {
				dateChars[i] = c;
				int year = Integer.parseInt(String.valueOf(dateChars));
				if (year <= 2011 && year >= previousDate && year < min) {
					min = year;
				}
			}
			dateChars[i] = tmp;
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] dates = new int[n];
		for (int i = 0; i < n; i++) {
			dates[i] = in.nextInt();
		}
		
		int[] newDates = new int[n];
		for (int i = 0; i < n; i++) {
			newDates[i] = changeDate(dates[i], i == 0 ? 1000 : newDates[i - 1]);
		}
		if (!valid(newDates)) {
			System.out.println("No solution");
		} else {
			for (int date : newDates) {
				System.out.println(date);
			}
		}
		
		in.close();
		System.exit(0);
	}
}

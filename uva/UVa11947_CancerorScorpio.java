package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3098 (11947 - Cancer or Scorpio) */
/* SUBMISSION: 09599275 */
/* SUBMISSION TIME: 2011-12-28 21:23:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11947_CancerorScorpio {
	
	static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static String[] zodiac = {"aquarius", "pisces", "aries", "taurus", "gemini", 
			           "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn"};
	static int[] begin = new int[12];
	
	static int dateToDays(int month, int day) { // 0-indexed
		int number = 0;
		
		for (int i = 0; i < month; ++i)
			number += months[i];
		number += day;
		
		return number;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		begin[0] = dateToDays(0, 20);
		begin[1] = dateToDays(1, 19);
		begin[2] = dateToDays(2, 20);
		begin[3] = dateToDays(3, 20);
		begin[4] = dateToDays(4, 21);
		begin[5] = dateToDays(5, 21);
		begin[6] = dateToDays(6, 22);
		begin[7] = dateToDays(7, 21);
		begin[8] = dateToDays(8, 23);
		begin[9] = dateToDays(9, 23);
		begin[10] = dateToDays(10, 22);
		begin[11] = dateToDays(11, 22);
		
		int leapday = dateToDays(1, 27);
						
		int T = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= T; ++t) {
			int date = Integer.parseInt(in.readLine().trim());
			int y = date % 10000;
			date /= 10000;
			int d = date % 100;
			date /= 100;
			int m = date % 100;
			date /= 100;
			
			int last = dateToDays(m - 1, d - 1);
			int birth = last + 40 * 7;
			
			int ybirth = y;
			if (birth >= 365) {
				++ybirth;
				birth %= 365;
			}
			
			if (birth > leapday && birth - leapday <= 40 * 7 &&
					ybirth % 4 == 0 && (ybirth % 100 != 0 || ybirth % 400 == 0))
				--birth;
			
			int mbirth = 0;
			int dbirth = 0;
			
			int tmp = -1;
			for (int i = 0; i < 12; ++i) {
				++mbirth;
				if (tmp + months[i] <= birth)
					tmp += months[i];
				else
					break;
			}
			dbirth = birth - tmp;
			
			String sign = zodiac[11];
			for (int i = 11; i >= 0; --i)
				if (birth >= begin[i]) {
					sign = zodiac[i];
					break;
				}
			
			System.out.printf("%d %02d/%02d/%04d %s\n", t, mbirth, dbirth, ybirth, sign);
		}
		
		in.close();
		System.exit(0);
	}
}
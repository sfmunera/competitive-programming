package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2284 (11309 - Counting Chaos) */
/* SUBMISSION: 09976839 */
/* SUBMISSION TIME: 2012-04-10 19:37:43 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11309_CountingChaos {
	
	static int toTimeNum(String time) {
		String[] parts = time.split("[:]");
		int hour = Integer.parseInt(parts[0]);
		int min = Integer.parseInt(parts[1]);
		
		return hour * 60 + min;
	}
	
	static String toTimeStr(int time) {
		int hour = time / 60;
		int min = time % 60;
		
		return String.format("%02d:%02d", hour, min);
	}
	
	static boolean isPalindrome(String timestr) {
		String str = "";
		
		int first = -1;
		for (int i = 0; i < timestr.length(); ++i) {
			if (timestr.charAt(i) == ':')
				continue;
			if (timestr.charAt(i) != '0' && first == -1)
					first = i;
			if (first != -1)
				str += timestr.charAt(i);
		}

		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - i - 1))
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String timestr = in.readLine();
			int time = toTimeNum(timestr);
			
			for (int t = (time + 1) % (24 * 60); ; t = (t + 1) % (24 * 60)) {
				String tstr = toTimeStr(t);
				if (isPalindrome(tstr)) {
					System.out.println(tstr);
					break;
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}
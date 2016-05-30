package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3967 (12522 - The Imperial Problem) */
/* SUBMISSION: 10772530 */
/* SUBMISSION TIME: 2012-10-21 19:05:51 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12522_TheImperialProblem {
	
	static String toRoman(int num) {
		String[][] conversion = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
							     {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
							     {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
							     {"", "M", "MM", "MMM", "", "", "", "", "", ""}};
		String roman = "";
		int pow = 0;
		while (num > 0) {
			roman = conversion[pow][num % 10] + roman;
			++pow;
			num /= 10;
		}
		
		return roman;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String bad = in.readLine();
			if (bad.equals("*")) break;
			
			int num = 0;
			for (int i = 0; i < bad.length(); ++i) {
				int val = 0;
				switch (bad.charAt(i)) {
				case 'I': val = 1; break;
				case 'V': val = 5; break;
				case 'X': val = 10; break;
				case 'L': val = 50; break;
				case 'C': val = 100; break;
				case 'D': val = 500; break;
				case 'M': val = 1000; break;
				}
				num += val;
			}
			
			String good = toRoman(num);
			int m = bad.length();
			int n = good.length();
			int beste = 1000;
			int bestc = 1000;
			for (int i = 0; i <= m - n; ++i) {
				int c = 0;
				for (int j = 0; j < n; ++j)
					if (good.charAt(j) != bad.charAt(i + j))
						++c;
				int e = m - n + c;
				
				if (e + c < beste + bestc) {
					beste = e;
					bestc = c;
				} else if (e + c == beste + bestc) {
					if (e < beste) {
						beste = e;
						bestc = c;
					}
				}
			}
			
			if (beste == 1000 && bestc == 1000) {
				beste = 0;
				bestc = 0;
			}
			System.out.println(beste + " " + bestc);
		}
		
		in.close();
		System.exit(0);
	}
}

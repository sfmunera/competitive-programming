package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2887 (11787 - Numeral Hieroglyphs) */
/* SUBMISSION: 11388614 */
/* SUBMISSION TIME: 2013-03-05 23:11:13 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11787_NumeralHieroglyphs {
	
	static int solve(String s) {
		String numbers = "BUSPFTM";
		int[] value = {1, 10, 100, 1000, 10000, 100000, 1000000};
		
		int val = 0;
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < s.length(); ++i) {
			int nval = value[numbers.indexOf(s.charAt(i))];
			if (nval < val) return -1;
			if (nval == val)
				++cnt;
			else
				cnt = 1;
			if (cnt > 9) return -1;
			ans += nval;
			val = nval;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String s = in.readLine();
			
			int ans1 = solve(s);
			int ans2 = solve(new StringBuffer(s).reverse().toString());
			
			if (ans1 == -1 && ans2 == -1)
				System.out.println("error");
			else if (ans1 == -1)
				System.out.println(ans2);
			else
				System.out.println(ans1);
		}
		
		in.close();
		System.exit(0);
	}
}

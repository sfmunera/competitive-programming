package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 65 (129 - Krypton Factor) */
/* SUBMISSION: 10543097 */
/* SUBMISSION TIME: 2012-08-30 14:49:28 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00129_KryptonFactor {
	
	static String ans;
	static int cnt;
	
	static boolean isEasy(String str) {
		for (int i = 1; i <= str.length(); ++i) {
			String str1 = str.substring(0, i);
			String str2 = str.substring(i);
			
			for (int j = 1; j <= str2.length(); ++j) {
				String str3 = str2.substring(0, j);
				if (str1.endsWith(str3))
					return true;
			}
		}
		return false;
	}
	
	static void solve(int n, int L, String cur) {
		if (!ans.isEmpty())
			return;
		if (isEasy(cur))
			return;

		++cnt;
		if (cnt == n) {
			ans = cur;
			return;
		}
		//System.out.println(n + " " + cur);
		for (int i = 0; i < L; ++i)
			solve(n, L, cur + (char)(i + 'A'));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[0]);
			int L = Integer.parseInt(parts[1]);
			
			if (n == 0 && L == 0)
				break;
			
			ans = "";
			cnt = -1;
			solve(n, L, "");
			
			for (int i = 0; i < ans.length(); i += 4) {
				String piece = ans.substring(i, Math.min(ans.length(), i + 4));
				System.out.print(piece);
				if ((i > 0 && i % 60 == 0) || i + 4 >= ans.length())
					System.out.println();
				else
					System.out.print(" ");
			}
			System.out.println(ans.length());
		}
		
		in.close();
		System.exit(0);
	}
}

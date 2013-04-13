package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3702 (1261 - String Popping) */
/* SUBMISSION: 10177698 */
/* SUBMISSION TIME: 2012-06-01 02:55:39 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa01261_StringPopping {
	
	static boolean solve(String str) {
		int n = str.length();
		if (n == 0)
			return true;
		
		boolean ok = false;
		for (int i = 1; i < n && !ok; ++i)
			if (str.charAt(i - 1) == str.charAt(i))
				ok = true;
		if (!ok)
			return false;
		
		for (int i = 0; i < n;) {
			int j = i;
			while (j < n && str.charAt(i) == str.charAt(j))
				++j;
			if (i + 1 < j) {
				StringBuilder sb = new StringBuilder();
				sb.append(str.substring(0, i)).append(str.substring(j));
				
				ok = solve(sb.toString());
				
				if (ok)
					return true;
			}
			i = j;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String str = in.readLine();
			sb.append((solve(str) ? "1" : "0") + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}

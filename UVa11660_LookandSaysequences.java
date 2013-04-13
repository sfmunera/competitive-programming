package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2707 (11660 - Look-and-Say sequences) */
/* SUBMISSION: 11593181 */
/* SUBMISSION TIME: 2013-04-11 19:02:24 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11660_LookandSaysequences {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder ans = new StringBuilder();
		
		while (true) {
			stk = new StringTokenizer(in.readLine());
			String x = stk.nextToken();
			int i = Integer.parseInt(stk.nextToken());
			int j = Integer.parseInt(stk.nextToken());
			
			if (x.equals("0") && i == 0 && j == 0) break;
			
			for (int k = 2; k <= i; ++k) {
				StringBuilder next = new StringBuilder();
				int cnt = 0;
				for (int l = 0; l < x.length() && next.length() < 1000; ++l) {
					if (l > 0 && x.charAt(l) != x.charAt(l - 1)) {
						next.append("" + cnt + x.charAt(l - 1));
						cnt = 0;
					}
					++cnt;
				}
				next.append("" + cnt + x.charAt(x.length() - 1));
				x = next.toString();
			}
			
			ans.append(x.charAt(j - 1) + "\n");
		}
		System.out.print(ans);
		
		in.close();
		System.exit(0);
	}
}

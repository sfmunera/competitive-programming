package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3121 (11970 - Lucky Numbers) */
/* SUBMISSION: 11388438 */
/* SUBMISSION TIME: 2013-03-05 21:50:01 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11970_LuckyNumbers {
		
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int i = 1; i * i < N; ++i) {
				int X = N - i * i;
				if (N % i == 0)
					ans.add(X);
			}
			Collections.sort(ans);
			System.out.print("Case " + t + ":");
			for (int X : ans) System.out.print(" " + X);
			System.out.println();
			
		}
		in.close();
		System.exit(0);
	}
}

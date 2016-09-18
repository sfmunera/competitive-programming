package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1265 (10324 - Zeros and Ones) */
/* SUBMISSION: 09232932 */
/* SUBMISSION TIME: 2011-09-07 01:40:58 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10324_ZerosandOnes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		String line;
		while ((line = in.readLine()) != null && !line.isEmpty()) {
			int N = Integer.parseInt(in.readLine());
			System.out.println("Case " + t + ":");
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				if (a > b) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				char c = line.charAt(a);
				boolean ok = true;
				for (int j = a + 1; j <= b; ++j)
					if (line.charAt(j) != c) {
						ok = false;
						break;
					}
				if (ok)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
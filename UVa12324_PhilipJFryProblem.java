package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3746 (12324 - Philip J. Fry Problem) */
/* SUBMISSION: 11573467 */
/* SUBMISSION TIME: 2013-04-08 01:30:18 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12324_PhilipJFryProblem {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			int[] t = new int[N];
			int[] b = new int[N];
			
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				t[i] = Integer.parseInt(stk.nextToken());
				b[i] = Integer.parseInt(stk.nextToken());
			}
			
			boolean[] taken = new boolean[N];
			for (int i = N - 1; i >= 0; --i) {
				while (b[i] > 0) {
					int max = 0;
					int maxAt = -1;
					for (int j = i + 1; j < N; ++j) {
						if (taken[j]) continue;
						if (t[j] > max) {
							max = t[j];
							maxAt = j;
						}
					}
					if (maxAt >= 0) {
						taken[maxAt] = true;
						--b[i];
					} else break;
				}
			}
			
			int ans = 0;
			for (int i = 0; i < N; ++i)
				ans += taken[i] ? t[i] / 2 : t[i];
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}

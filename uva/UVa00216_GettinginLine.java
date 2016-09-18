package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 152 (216 - Getting in Line) */
/* SUBMISSION: 11433002 */
/* SUBMISSION TIME: 2013-03-13 16:47:32 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00216_GettinginLine {
	
	static void swap(int[] c, int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(int[] c) {
		int N = c.length;
		int k = -1;
		for (int i = N - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break;
			}
		if (k == -1) return false;
		int l = 0;
		for (int i = N - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break;
			}
		swap(c, k, l);
		for (int i = k + 1; i < (N + k + 1) / 2; ++i)
			swap(c, i, N + k - i);
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			int[] x = new int[N];
			int[] y = new int[N];
			int[] perm = new int[N];
			
			for (int i = 0; i < N; ++i) {
				perm[i] = i;
				StringTokenizer stk = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(stk.nextToken());
				y[i] = Integer.parseInt(stk.nextToken());
			}
			
			double min = Double.MAX_VALUE;
			int[] best = new int[N];
			do {
				double len = 0.0;
				for (int i = 1; i < N; ++i) {
					int dx = x[perm[i]] - x[perm[i - 1]];
					int dy = y[perm[i]] - y[perm[i - 1]];
					len += Math.sqrt(dx * dx + dy * dy);
				}
				if (len < min - 1e-9) {
					min = len;
					best = perm.clone();
				}
			} while (nextPermutation(perm));
			
			double ans = 0.0;
			
			System.out.println("**********************************************************");
			System.out.println("Network #" + t);
			for (int i = 1; i < N; ++i) {
				int dx = x[best[i]] - x[best[i - 1]];
				int dy = y[best[i]] - y[best[i - 1]];
				double tmp = 16.0 + Math.sqrt(dx * dx + dy * dy);
				ans += tmp;
				
				System.out.printf(Locale.ENGLISH, "Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n",
						x[best[i - 1]], y[best[i - 1]], x[best[i]], y[best[i]], tmp);
			}
			System.out.printf(Locale.ENGLISH, "Number of feet of cable required is %.2f.\n", ans);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}

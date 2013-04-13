package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2842 (11742 - Social Constraints) */
/* SUBMISSION: 09620818 */
/* SUBMISSION TIME: 2012-01-05 18:56:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11742_SocialConstraints {
	
	static void swap(int[] c, int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(int[] c) {
		int n = c.length;
		int k = -1;
		for (int i = n - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break;
			}
		if (k == -1)
			return false;
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break;
			}
		swap(c, k, l);
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(c, i, n + k - i);
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts;
		while (true) {
			parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			
			if (n == 0 && m == 0)
				break;
			
			int[] teens = new int[n];
			for (int i = 0; i < n; ++i) teens[i] = i;
			
			int[] a = new int[m];
			int[] b = new int[m];
			int[] c = new int[m];
			
			for (int i = 0; i < m; ++i) {
				parts = in.readLine().split("[ ]+");
				a[i] = Integer.parseInt(parts[0]);
				b[i] = Integer.parseInt(parts[1]);
				c[i] = Integer.parseInt(parts[2]);
			}
			
			int cnt = 0;
			do {
				boolean ok = true;
				for (int i = 0; i < m && ok; ++i) {
					int inda = 0;
					int indb = 0;
					for (int j = 0; j < n; ++j)
						if (teens[j] == a[i])
							inda = j;
						else if (teens[j] == b[i])
							indb = j;
					
					if (c[i] < 0) {
						if (Math.abs(inda - indb) < -c[i])
							ok = false;
					} else {
						if (Math.abs(inda - indb) > c[i])
						ok = false;
					}
				}
				
				if (ok)
					++cnt;
			} while (nextPermutation(teens));
			
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
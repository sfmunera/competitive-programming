package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2548 (11553 - Grid Game) */
/* SUBMISSION: 11038658 */
/* SUBMISSION TIME: 2012-12-16 23:00:01 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11553_GridGame {
	
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
		if (k == -1) return false;
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
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int[][] M = new int[N][N];
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				for (int j = 0; j < N; ++j)
					M[i][j] = Integer.parseInt(parts[j]);
			}
			
			int[] arr = new int[N];
			for (int i = 0; i < N; ++i)
				arr[i] = i;
			int ans = Integer.MAX_VALUE;
			do {
				int sum = 0;
				for (int i = 0; i < N; ++i) sum += M[i][arr[i]];
				ans = Math.min(ans, sum);
			} while (nextPermutation(arr));
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}

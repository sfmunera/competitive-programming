package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1285 (10344 - 23 out of 5) */
/* SUBMISSION: 10117505 */
/* SUBMISSION TIME: 2012-05-15 19:13:09 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.Arrays;

public class UVa10344_23outof5 {
	
	static boolean possible;
	
	static void swap(int[] c, int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(int[] c) {
		int n = c.length ;
		int k = -1;
		for (int i = n - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break ;
			}
		if ( k == -1)
			return false ;
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break ;
			}
		swap(c, k, l) ;
		
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(c, i, n + k - i) ;
		
		return true;
	}
	
	static void solve(int[] a, int cur, int k) {
		if (k == 5) {
			if (cur == 23)
				possible = true;
			return;
		}
		
		solve(a, cur * a[k], k + 1);
		solve(a, cur + a[k], k + 1);
		solve(a, cur - a[k], k + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int[] a = new int[5];
			String[] parts = in.readLine().split("[ ]+");
			
			for (int i = 0; i < 5; ++i)
				a[i] = Integer.parseInt(parts[i]);
			
			if (a[0] == 0 && a[1] == 0 && a[2] == 0 && a[3] == 0 && a[4] == 0)
				break;
			
			Arrays.sort(a);
			
			possible = false;
			do {
				solve(a, a[0], 1);
			} while (nextPermutation(a));
			
			if (possible)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
		
		in.close();
		System.exit(0);
	}
}

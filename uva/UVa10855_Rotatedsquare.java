package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1796 (10855 - Rotated square) */
/* SUBMISSION: 09231926 */
/* SUBMISSION TIME: 2011-09-06 18:47:14 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10855_Rotatedsquare {
	
	static void rotate(char[][] a) {
		int m = a.length;
		
		char[][] b = new char[m][m];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < m; ++j)
				b[i][j] = a[m - j - 1][i];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < m; ++j)
				a[i][j] = b[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int N = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && n == 0)
				break;
			char[][] big = new char[N][N];
			char[][] small = new char[n][n];
			
			for (int i = 0; i < N; ++i)
				big[i] = in.readLine().toCharArray();
			for (int i = 0; i < n; ++i)
				small[i] = in.readLine().toCharArray();
			
			int[] cnt = new int[4];
			for (int i = 0; i < 4; ++i) {
				
				for (int j = 0; j <= N - n; ++j)
					for (int k = 0; k <= N - n; ++k) {
						boolean found = true;
						for (int a = 0; a < n && found; ++a)
							for (int b = 0; b < n && found; ++b)
								if (big[j + a][k + b] != small[a][b])
									found = false;
						if (found)
							++cnt[i];
					}
				rotate(small);
			}
			System.out.println(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3]);
		}
		
		in.close();
		System.exit(0);
	}
}

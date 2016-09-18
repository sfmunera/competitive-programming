package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2545 (11550 - Demanding Dilemma) */
/* SUBMISSION: 11518605 */
/* SUBMISSION TIME: 2013-03-27 22:08:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11550_DemandingDilemma {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			int[][] mat = new int[N][M];
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; ++j)
					mat[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			boolean ok = true;

			for (int j = 0; j < M; ++j) {
				int cnt = 0;
				for (int i = 0; i < N; ++i)
					cnt += mat[i][j];
				if (cnt != 2) {
					ok = false;
					break;
				}
			}
			
			if (ok) {
				for (int j = 0; j < M; ++j) {
					int cnt = 0;
					int[] edge = {-1, -1};
					for (int i = 0; i < N; ++i)
						if (mat[i][j] == 1)
							edge[cnt++] = i;
					for (int k = 0; k < M; ++k)
						if (k != j) {
							int cnt2 = 0;
							int[] edge2 = {-1, -1};
							for (int i = 0; i < N; ++i)
								if (mat[i][k] == 1)
									edge2[cnt2++] = i;
							if (edge[0] == edge2[0] && edge[1] == edge2[1]) {
								ok = false;
								break;
							}
						}
					if (!ok) break;
				}
			}
			
			System.out.println(ok ? "Yes" : "No");
		}
		
		in.close();
		System.exit(0);
	}
}

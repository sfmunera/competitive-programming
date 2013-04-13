package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1849 (10908 - Largest Square) */
/* SUBMISSION: 10198590 */
/* SUBMISSION TIME: 2012-06-06 20:26:51 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10908_LargestSquare {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int M = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			int Q = Integer.parseInt(parts[2]);
			
			char[][] grid = new char[M][N];
			for (int i = 0; i < M; ++i)
				grid[i] = in.readLine().toCharArray();
			
			System.out.println(M + " " + N + " " + Q);
			for (int q = 0; q < Q; ++q) {
				parts = in.readLine().split("[ ]+");
				int r = Integer.parseInt(parts[0]);
				int c = Integer.parseInt(parts[1]);
				
				int max = 0;
				for (int k = 0; ; ++k) {
					int r1 = r - k;
					int r2 = r + k;
					int c1 = c - k;
					int c2 = c + k;
					
					if (r1 < 0 || c1 < 0 || r2 >= M || c2 >= N) break;
					
					boolean ok = true;
					char ch = grid[r][c];
					for (int i = r1; i <= r2 && ok; ++i)
						for (int j = c1; j <= c2 && ok; ++j)
							if (grid[i][j] != ch)
								ok = false;
					
					if (ok)
						max = 2 * k + 1;
					else
						break;
				}
				System.out.println(max);
			}
		}
		
		in.close();
		System.exit(0);
	}
}

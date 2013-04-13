package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1015 (10074 - Take the Land) */
/* SUBMISSION: 10168873 */
/* SUBMISSION TIME: 2012-05-29 19:18:17 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10074_TaketheLand {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int M = Integer.parseInt(parts[0]);
			int N = Integer.parseInt(parts[1]);
			
			if (M == 0 && N == 0)
				break;
			
			int[][] A = new int[M][N];
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				for (int j = 0; j < N; ++j) {
					A[i][j] = (Integer.parseInt(parts[j]) == 0 ? 1 : 0);
					if (i > 0) A[i][j] += A[i - 1][j];
					if (j > 0) A[i][j] += A[i][j - 1];
					if (i > 0 && j > 0) A[i][j] -= A[i - 1][j - 1];
				}
			}
			
			int max = 0;
			for (int i = 0; i < M; ++i)
				for (int j = 0; j < N; ++j)
					for (int k = i; k < M; ++k)
						for (int l = j; l < N; ++l) {
							int sub = A[k][l];
							if (i > 0) sub -= A[i - 1][l];
							if (j > 0) sub -= A[k][j - 1];
							if (i > 0 && j > 0) sub += A[i - 1][j - 1];
							
							int area = (k - i + 1) * (l - j + 1);
							if (area == sub)
								max = Math.max(max, sub);
						}
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}

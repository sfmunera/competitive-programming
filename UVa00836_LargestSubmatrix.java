package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 777 (836 - Largest Submatrix) */
/* SUBMISSION: 10168743 */
/* SUBMISSION TIME: 2012-05-29 18:37:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00836_LargestSubmatrix {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			char[] line = in.readLine().toCharArray();
			int N = line.length;
			
			int[][] A = new int[N][N];
			for (int i = 0; i < N; ++i)
				A[0][i] = line[i] - '0';
			
			for (int i = 1; i < N; ++i) {
				line = in.readLine().toCharArray();
				for (int j = 0; j < N; ++j)
					A[i][j] = line[j] - '0';
			}
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j) {
					if (i > 0) A[i][j] += A[i - 1][j];
					if (j > 0) A[i][j] += A[i][j - 1];
					if (i > 0 && j > 0) A[i][j] -= A[i - 1][j - 1];
				}
			
			int max = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					for (int k = i; k < N; ++k)
						for (int l = j; l < N; ++l) {
							int sub = A[k][l];
							if (i > 0) sub -= A[i - 1][l];
							if (j > 0) sub -= A[k][j - 1];
							if (i > 0 && j > 0) sub += A[i - 1][j - 1];
							
							int area = (k - i + 1) * (l - j + 1);
							if (sub == area)
								max = Math.max(max, sub);
						}
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}

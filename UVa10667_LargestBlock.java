package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1608 (10667 - Largest Block) */
/* SUBMISSION: 10169014 */
/* SUBMISSION TIME: 2012-05-29 20:02:58 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10667_LargestBlock {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int p = Integer.parseInt(in.readLine());
		while (p-- > 0) {
			int s = Integer.parseInt(in.readLine());
			int[][] A = new int[s][s];
			
			for (int i = 0; i < s; ++i)
				Arrays.fill(A[i], 1);
			
			int b = Integer.parseInt(in.readLine());
			for (int k = 0; k < b; ++k) {
				String[] parts = in.readLine().split("[ ]+");
				int r1 = Integer.parseInt(parts[0]) - 1;
				int c1 = Integer.parseInt(parts[1]) - 1;
				int r2 = Integer.parseInt(parts[2]) - 1;
				int c2 = Integer.parseInt(parts[3]) - 1;
				
				for (int i = r1; i <= r2; ++i)
					for (int j = c1; j <= c2; ++j)
						A[i][j] = 0;
			}

			for (int i = 0; i < s; ++i)
				for (int j = 0; j < s; ++j) {
					if (i > 0) A[i][j] += A[i - 1][j];
					if (j > 0) A[i][j] += A[i][j - 1];
					if (i > 0 && j > 0) A[i][j] -= A[i - 1][j - 1];
				}

			int max = 0;
			for (int i = 0; i < s; ++i)
				for (int j = 0; j < s; ++j)
					for (int k = i; k < s; ++k)
						for (int l = j; l < s; ++l) {
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
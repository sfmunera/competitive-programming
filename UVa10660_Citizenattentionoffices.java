package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1601 (10660 - Citizen attention offices) */
/* SUBMISSION: 11035556 */
/* SUBMISSION TIME: 2012-12-16 05:49:11 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10660_Citizenattentionoffices {
	
	static int minDist(int r, int c, int office) {
		int i = office / 5;
		int j = office % 5;
		return Math.abs(r - i) + Math.abs(c - j);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int[][] population = new int[5][5];
			int n = Integer.parseInt(in.readLine());
			for (int i = 0; i < n; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int r = Integer.parseInt(parts[0]);
				int c = Integer.parseInt(parts[1]);
				int v = Integer.parseInt(parts[2]);
				population[r][c] = v;
			}
			
			int[] best = new int[5];
			int min = Integer.MAX_VALUE;
			for (int a = 0; a < 25; ++a)
				for (int b = a + 1; b < 25; ++b)
					for (int c = b + 1; c < 25; ++c)
						for (int d = c + 1; d < 25; ++d)
							for (int e = d + 1; e < 25; ++e) {
								int dist = 0;
								for (int i = 0; i < 5; ++i)
									for (int j = 0; j < 5; ++j) {
										int d1 = Integer.MAX_VALUE;
										d1 = Math.min(d1, minDist(i, j, a));
										d1 = Math.min(d1, minDist(i, j, b));
										d1 = Math.min(d1, minDist(i, j, c));
										d1 = Math.min(d1, minDist(i, j, d));
										d1 = Math.min(d1, minDist(i, j, e));
										dist += population[i][j] * d1;
									}
								
								if (dist < min) {
									min = dist;
									best[0] = a;
									best[1] = b;
									best[2] = c;
									best[3] = d;
									best[4] = e;
								}
							}
			
			for (int i = 0; i < 5; ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(best[i]);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}

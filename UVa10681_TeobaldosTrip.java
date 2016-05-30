package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1622 (10681 - Teobaldo's Trip) */
/* SUBMISSION: 10155861 */
/* SUBMISSION TIME: 2012-05-25 18:25:21 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10681_TeobaldosTrip {
	
	static long[][] eye(int N) {
		long[][] I = new long[N][N];
		for (int i = 0; i < N; ++i)
			I[i][i] = 1;
		
		return I;
	}
	
	static long[][] multiply(long[][] A, long[][] B) {
		int N = A.length;
		
		long[][] C = new long[N][N];
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				for (int k = 0; k < N; ++k)
					C[i][j] |= A[i][k] & B[k][j];
		return C;
	}
	
	static long[][] fastPow(long[][] A, int N, int D) {
		if (D == 0)
			return eye(N);
		if (D == 1)
			return A;
		
		if (D % 2 == 0) {
			long[][] tmp = fastPow(A, N, D / 2);
			return multiply(tmp, tmp);
		} else {
			long[][] tmp = fastPow(A, N, (D - 1) / 2);
			return multiply(A, multiply(tmp, tmp));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		while (true) {
			
			if (first)
				first = false;
			else
				in.readLine();
			
			String[] parts = in.readLine().split("[ ]+");
			int C = Integer.parseInt(parts[0]);
			int L = Integer.parseInt(parts[1]);
			
			if (C == 0 && L == 0)
				break;
			
			long[][] adj = new long[C][C];
			for (int i = 0; i < L; ++i) {
				parts = in.readLine().split("[ ]+");
				int from = Integer.parseInt(parts[0]) - 1;
				int to = Integer.parseInt(parts[1]) - 1;
				adj[from][to] = adj[to][from] = 1;
			}
			
			parts = in.readLine().split("[ ]+");
			
			int S = Integer.parseInt(parts[0]) - 1;
			int E = Integer.parseInt(parts[1]) - 1;
			int D = Integer.parseInt(parts[2]);
			
			long[][] adjD = fastPow(adj, C, D);
			
			//for (int i = 0; i < C; ++i)
			//	System.out.println(Arrays.toString(adjD[i]));
			
			if (adjD[S][E] != 0)
				System.out.println("Yes, Teobaldo can travel.");
			else
				System.out.println("No, Teobaldo can not travel.");
			
		}
		
		in.close();
		System.exit(0);
	}
}

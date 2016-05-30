package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 87 (151 - Power Crisis) */
/* SUBMISSION: 11080422 */
/* SUBMISSION TIME: 2012-12-27 20:43:18 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00151_PowerCrisis {
	
	static int simulate(int N, int M) {
		boolean[] kill = new boolean[N];
		int p = 0;
		kill[p] = true;
		for (int r = 0; r < N - 1; ++r) {
			int k = 0;
			for (int i = 0; i < M;) {
				if (!kill[(p + k + 1) % N])
					++i;
				++k;
			}
			p = (p + k) % N;
			kill[p] = true;
		}
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			for (int M = 1; M < N; ++M)
				if (simulate(N, M) == 12) {
					System.out.println(M);
					break;
				}
		}
		
		in.close();
		System.exit(0);
	}
}

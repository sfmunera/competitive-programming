package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 241 (305 - Joseph) */
/* SUBMISSION: 11080962 */
/* SUBMISSION TIME: 2012-12-28 02:44:23 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00305_Joseph {
	static boolean simulate(int N, int M) {
		int K = N / 2;
		int p = -1;
		List<Integer> q = new ArrayList<Integer>();
		for (int i = 0; i < N; ++i)
			q.add(i + 1);
		for (int r = 0; r < K; ++r) {
			p = (p + M) % q.size();
			q.remove(p);
			--p;
			if (p < 0) p = q.size() - 1;
		}
		for (int i = 0; i < q.size(); ++i)
			if (q.get(i) != i + 1)
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/*int[] ans = new int[14];
		for (int k = 1; k < 14; ++k)
			for (int M = 1; ; ++M)
				if (simulate(2 * k, M)) {
					ans[k] = M;
					System.out.println(M);
					break;
				}*/
		int[] ans = {0, 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 2504881};
		
		while (true) {
			int K = Integer.parseInt(in.readLine());
			if (K == 0) break;
			
			System.out.println(ans[K]);
		}
		
		in.close();
		System.exit(0);
	}
}
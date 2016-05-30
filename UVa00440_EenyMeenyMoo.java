package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 381 (440 - Eeny Meeny Moo) */
/* SUBMISSION: 11081093 */
/* SUBMISSION TIME: 2012-12-28 04:07:17 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00440_EenyMeenyMoo {
	static int simulate(int N, int M) {
		int p = -1;
		List<Integer> q = new ArrayList<Integer>();
		for (int i = 1; i < N; ++i)
			q.add(i + 1);
		for (int r = 0; r < N - 2; ++r) {
			p = (p + M) % q.size();
			q.remove(p);
			--p;
			if (p < 0) p = q.size() - 1;
		}
		return q.get(0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			for (int M = 1; ; ++M)
				if (simulate(N, M) == 2) {
					System.out.println(M);
					break;
				}
		}
		
		in.close();
		System.exit(0);
	}
}

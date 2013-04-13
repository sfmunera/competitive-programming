package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1066 (10125 - Sumsets) */
/* SUBMISSION: 10117384 */
/* SUBMISSION TIME: 2012-05-15 18:40:58 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10125_Sumsets {
	
	static class Pair {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int[] S = new int[N];
			
			for (int i = 0; i < N; ++i)
				S[i] = Integer.parseInt(in.readLine());
			Arrays.sort(S);
			
			Map<Integer, Pair> ab = new HashMap<Integer, Pair>();
			for (int i = 0; i < N - 1; ++i)
				for (int j = i + 1; j < N; ++j)
					ab.put(S[i] + S[j], new Pair(S[i], S[j]));
			
			boolean done = false;
			for (int i = N - 1; i >= 0 && !done; --i) {
				int d = S[i];
				for (int j = 0; j < N && !done; ++j)
					if (i != j) {
						int c = S[j];
						if (ab.containsKey(d - c)) {
							Pair p = ab.get(d - c);
							if (p.a != c && p.a != d && p.b != c && p.b != d) {
								System.out.println(d);
								done = true;
							}
						}
					}
			}
			
			if (!done)
				System.out.println("no solution");
		}
		
		in.close();
		System.exit(0);
	}
}

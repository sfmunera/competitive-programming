package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1239 (10298 - Power Strings) */
/* SUBMISSION: 10262166 */
/* SUBMISSION TIME: 2012-06-26 20:50:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10298_PowerStrings {
	
	static String P, T;
	static int M, N;
	static int[] b;
	
	static void kmpPreprocess() {
		int i = 0, j = -1;
		b[0] = -1;
		
		while (i < M) {
			while (j >= 0 && P.charAt(i) != P.charAt(j)) j = b[j];
			++i; ++j;
			b[i] = j;
		}
	}
	
	static int kmpSearch() {
		int i = 0, j = 0;
		
		boolean first = true;
		while (i < N) {
			while (j >= 0 && T.charAt(i) != P.charAt(j)) j = b[j];
			++i; ++j;
			if (j == M) {
				//System.out.println("Found at index " + (i - j));
				if (first)
					first = false;
				else
					return i - j;
				j = b[j];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			P = in.readLine();
			if (P.equals("."))
				break;
			
			M = P.length();
			T = P + P;
			N = 2 * M;
			
			b = new int[M + 1];

			kmpPreprocess();
			int ind = kmpSearch();
			System.out.println(M / ind);
		}
		
		in.close();
		System.exit(0);
	}
}
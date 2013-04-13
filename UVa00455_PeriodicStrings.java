package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 396 (455 - Periodic Strings) */
/* SUBMISSION: 10262150 */
/* SUBMISSION TIME: 2012-06-26 20:46:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00455_PeriodicStrings {
	
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
		
		boolean first = true;
		int K = Integer.parseInt(in.readLine());
		while (K-- > 0) {
			in.readLine();
			P = in.readLine();
			M = P.length();
			T = P + P;
			N = 2 * M;
			
			b = new int[M + 1];
			
			if (first)
				first = false;
			else
				System.out.println();
			
			kmpPreprocess();
			int ind = kmpSearch();
			System.out.println(ind);
		}
		
		in.close();
		System.exit(0);
	}
}

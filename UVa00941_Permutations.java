package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 882 (941 - Permutations) */
/* SUBMISSION: 11038174 */
/* SUBMISSION TIME: 2012-12-16 19:17:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00941_Permutations {
	static long[] f;
	
	static String nthPermutation(long N, String cur) {
		if (cur.length() < 2) return cur;
		int ind = (int)(N / f[cur.length() - 1]);
		return cur.charAt(ind) + nthPermutation(N % f[cur.length() - 1], cur.substring(0, ind) + cur.substring(ind + 1));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		f = new long[21];
		f[0] = 1L;
		for (int i = 1; i <= 20; ++i)
			f[i] = i * f[i - 1];
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String S = in.readLine();
			long N = Long.parseLong(in.readLine());
			
			char[] tmp = S.toCharArray();
			Arrays.sort(tmp);
			System.out.println(nthPermutation(N, String.valueOf(tmp)));
		}
		
		in.close();
		System.exit(0);
	}
}

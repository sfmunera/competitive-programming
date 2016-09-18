package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2988 (11888 - Abnormal 89's) */
/* SUBMISSION: 10262393 */
/* SUBMISSION TIME: 2012-06-26 22:55:07 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11888_Abnormal89s {
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
		
		while (i < N) {
			while (j >= 0 && T.charAt(i) != P.charAt(j)) j = b[j];
			++i; ++j;
			if (j == M) {
				if (i - j > 0)
					return i - j;
				j = b[j];
			}
		}
		return -1;
	}
	
	static boolean isPalindrome(String str) {
		int N = str.length();
		for (int i = 0; i < N / 2; ++i)
			if (str.charAt(i) != str.charAt(N - 1 - i))
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		while (K-- > 0) {
			String str = in.readLine();
			P = new StringBuffer(str).reverse().toString();
			T = str + str;
			
			N = T.length();
			M = P.length();
			
			b = new int[M + 1];
			
			kmpPreprocess();
			int ind = kmpSearch();
			if (ind > 0 && ind < M)
				System.out.println("alindrome");
			else if (isPalindrome(str))
				System.out.println("palindrome");
			else
				System.out.println("simple");
		}
		
		in.close();
		System.exit(0);
	}
}

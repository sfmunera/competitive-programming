package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 954 (10013 - Super long sums) */
/* SUBMISSION: 11376333 */
/* SUBMISSION TIME: 2013-03-03 21:22:44 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10013_Superlongsums {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		boolean first = true;
		while (N-- > 0) {
			in.readLine();
			int M = Integer.parseInt(in.readLine());
			
			int[] n1 = new int[M];
			int[] n2 = new int[M];
			
			for (int i = 0; i < M; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				n1[i] = stk.nextToken().charAt(0) - '0';
				n2[i] = stk.nextToken().charAt(0) - '0';
			}
			
			if (first) first = false; else System.out.println();
			
			char[] ans = new char[M];
			int carry = 0;
			for (int i = M - 1; i >= 0; --i) {
				int sum = n1[i] + n2[i] + carry;
				ans[i] = (char)(sum % 10 + '0');
				carry = sum / 10;
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}

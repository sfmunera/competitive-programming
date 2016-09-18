package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2000 (11059 - Maximum Product) */
/* SUBMISSION: 09196199 */
/* SUBMISSION TIME: 2011-08-27 16:49:52 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11059_MaximumProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			StringTokenizer stk = new StringTokenizer(in.readLine());
			in.readLine();
			
			int[] sequence = new int[N];
			long max = 0;
			int i = 0;
			while (stk.hasMoreTokens())
				sequence[i++] = Integer.parseInt(stk.nextToken());
			
			for (int j = 0; j < N; ++j) {
				long prod = 1;
				for (int k = j; k < N; ++k) {
					prod *= sequence[k];
					max = Math.max(max, prod);
				}
			}
			System.out.println("Case #" + t + ": The maximum product is " + max + ".");
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
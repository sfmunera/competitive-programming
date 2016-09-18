package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2354 (11369 - Shopaholic) */
/* SUBMISSION: 08961986 */
/* SUBMISSION TIME: 2011-06-17 19:26:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11369_Shopaholic {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		while (T-- > 0) {
			int n = Integer.parseInt(in.readLine().trim());
			int[] prices = new int[n];
			
			String line = in.readLine().trim();
			StringTokenizer stk = new StringTokenizer(line);
			for (int i = 0; i < n; ++i)
				prices[i] = Integer.parseInt(stk.nextToken());
			Arrays.sort(prices);
			int total = 0;
			
			for (int i = prices.length - 1; i >= 0; --i) {
				if ((prices.length - i) % 3 == 0)
					total += prices[i];
			}
			System.out.println(total);
		}
	}
}
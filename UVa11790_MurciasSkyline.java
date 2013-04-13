package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2890 (11790 - Murcia's Skyline) */
/* SUBMISSION: 11422304 */
/* SUBMISSION TIME: 2013-03-11 19:02:10 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11790_MurciasSkyline {
	
	static int[] lis(int[] h, int[] w) {
		int N = h.length;
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		
		int ans1 = w[0];
		int ans2 = w[0];
		dp1[0] = w[0];
		dp2[0] = w[0];
		for (int i = 1; i < N; ++i) {
			int max1 = 0;
			int max2 = 0;
			for (int j = 0; j < i; ++j) {
				if (h[i] > h[j])
					max1 = Math.max(max1, dp1[j]);
				if (h[i] < h[j])
					max2 = Math.max(max2, dp2[j]);
			}
			dp1[i] = max1 + w[i];
			dp2[i] = max2 + w[i];
			ans1 = Math.max(ans1, dp1[i]);
			ans2 = Math.max(ans2, dp2[i]);
		}
		return new int[]{ans1, ans2};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			int[] h = new int[N];
			int[] w = new int[N];
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i)
				h[i] = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i)
				w[i] = Integer.parseInt(stk.nextToken());
			
			int[] ans = lis(h, w);
			int inc = ans[0];
			int dec = ans[1];
			
			if (inc >= dec)
				System.out.println("Case " + t + ". Increasing (" + inc + "). Decreasing (" + dec + ").");
			else
				System.out.println("Case " + t + ". Decreasing (" + dec + "). Increasing (" + inc + ").");
		}
		
		in.close();
		System.exit(0);
	}
}

package uva;

import java.util.*;
import java.io.*;

public class UVa10465_HomerSimpson {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			// Assume m <= n always
			if (m > n) {
				int tmp = m;
				m = n;
				n = tmp;
			}
			
			int[] dp1 = new int[t + 1];
			int[] dp2 = new int[t + 1];
			
			// To determine the minimum beer time
			for (int i = 0; i < m && i <= t; ++i)
				dp1[i] = i;
			for (int i = m; i <= t; ++i) { // time left
				dp1[i] = dp1[i - m];
				if (i >= n)
					dp1[i] = Math.min(dp1[i], dp1[i - n]);
			}
			int beerTime = dp1[t];
			
			// To determine the max number of burgers in t-beerTime
			dp2[0] = 0;
			for (int i = 1; i < m && i <= t; ++i)
				dp2[i] = Integer.MIN_VALUE; // It has to fit exactly in the time
			for (int i = m; i <= t - beerTime; ++i) { // time left
				dp2[i] = 1 + dp2[i - m];
				if (i >= n)
					dp2[i] = Math.max(dp2[i], 1 + dp2[i - n]);
			}

			System.out.println(dp2[t - beerTime] + (beerTime > 0 ? " " + beerTime : ""));
		}
		
		in.close();
		System.exit(0);
	}
}

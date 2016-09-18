package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1871 (10930 - A-Sequence) */
/* SUBMISSION: 10940028 */
/* SUBMISSION TIME: 2012-11-26 00:40:29 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10930_ASequence {
	
	static int N;
	static int[] seq;
	static int[][] dp;
	
	static int ways(int i, int v) {
		//System.out.println("N = " + N + ", i = " + i + ", v = " + v + ", seq[i] = " + seq[i]);
		if (v == 0) return 1;
		if (v < 0) return 0;
		if (i == N) return 0;
		
		if (dp[i][v] != -1) return dp[i][v];
		return dp[i][v] = ways(i + 1, v) + ways(i + 1, v - seq[i]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new int[35][1005];
		
		int t = 1;
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int len = Integer.parseInt(parts[0]);
			seq = new int[len];
			
			boolean ok = true;
			for (int i = 0; i < len; ++i)
				seq[i] = Integer.parseInt(parts[i + 1]);
			for (int i = 1; i < len; ++i)
				if (seq[i] <= seq[i - 1])
					ok = false;
			
			if (seq[0] < 1) ok = false;
			if (ok)
				for (int i = 1; i < len; ++i) {
					N = i;
					for (int k = 0; k < 35; ++k)
						Arrays.fill(dp[k], -1);
					//System.out.println("N = " + N + ", v = " + seq[i] + ", ans = " + ways(0, seq[i]));
					if (ways(0, seq[i]) > 0) {
						ok = false;
						break;
					}
				}
			System.out.print("Case #" + t + ":");
			for (int i = 0; i < len; ++i)
				System.out.print(" " + seq[i]);
			System.out.println();
			System.out.println("This is " + (ok ? "" : "not ") + "an A-sequence.");
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}

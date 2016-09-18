package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 378 (437 - The Tower of Babylon) */
/* SUBMISSION: 11428481 */
/* SUBMISSION TIME: 2013-03-13 04:32:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00437_TheTowerofBabylon {
	
	static class Triple implements Comparable<Triple> {
		int x, y, z;
		public Triple(int x, int y, int z) {
			this.x = x; this.y = y; this.z = z;
		}
		public int compareTo(Triple t) {
			if (this.x != t.x) return this.x - t.x;
			if (this.y != t.y) return this.y - t.y;
			return this.z - t.z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			Triple[] blocks = new Triple[N * 6];
			int k = 0;
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int z = Integer.parseInt(stk.nextToken());
				blocks[k++] = new Triple(x, y, z);
				blocks[k++] = new Triple(x, z, y);
				blocks[k++] = new Triple(y, x, z);
				blocks[k++] = new Triple(y, z, x);
				blocks[k++] = new Triple(z, x, y);
				blocks[k++] = new Triple(z, y, x);
			}
			
			Arrays.sort(blocks);
			
			int[] dp = new int[N * 6];
			int ans = 0;
			for (int i = 0; i < N * 6; ++i) {
				int max = 0;
				for (int j = 0; j < i; ++j)
					if (blocks[i].x > blocks[j].x && blocks[i].y > blocks[j].y)
						max = Math.max(max, dp[j]);
				dp[i] = max + blocks[i].z;
				ans = Math.max(ans, dp[i]);
			}
			System.out.println("Case " + t + ": maximum height = " + ans);
			
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}

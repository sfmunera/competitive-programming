package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1437 (10496 - Collecting Beepers) */
/* SUBMISSION: 09036281 */
/* SUBMISSION TIME: 2011-07-10 15:16:05 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10496_CollectingBeepers {
	
	static int xSize;
	static int ySize;
	static int x0;
	static int y0;
	static int n;
	static boolean[] used;
	static Beeper[] beepers;
	static int res;
	
	static class Beeper {
		int x;
		int y;
		
		public Beeper(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void solve(Beeper[] b, int k) {
		if (k == n) {
			int shortest = Math.abs(x0 - b[0].x) + Math.abs(y0 - b[0].y);
			for (int i = 1; i < n; ++i)
				shortest += Math.abs(b[i].x - b[i - 1].x) + 
					Math.abs(b[i].y - b[i - 1].y);
			shortest += Math.abs(x0 - b[n - 1].x) + Math.abs(y0 - b[n - 1].y);
			
			res = Math.min(res, shortest);
		}
		
		for (int i = 0; i < n; ++i) {
			if (used[i])
				continue;
			used[i] = true;
			b[k] = beepers[i];
			solve(b, k + 1);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		while (N-- > 0) {
			xSize = in.nextInt();
			ySize = in.nextInt();
			x0 = in.nextInt();
			y0 = in.nextInt();
			n = in.nextInt();
			beepers = new Beeper[n];
			used = new boolean[n];
			
			for (int i = 0; i < n; ++i)
				beepers[i] = new Beeper(in.nextInt(), in.nextInt());
			
			res = Integer.MAX_VALUE;
			Beeper[] b = beepers.clone();
			solve(b, 0);
			
			System.out.println("The shortest path has length " + res);
		}
	}
}
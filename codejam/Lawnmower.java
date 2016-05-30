package codejam;

import java.io.*;
import java.util.*;

public class Lawnmower {
	
	static void mow(int[][] lawn, boolean[][] taken, int h) {
		int R = lawn.length;
		int C = lawn[0].length;
		
		for (int i = 0; i < R; ++i) {
			Set<Integer> set = new HashSet<Integer>();
			int val = -1;
			for (int j = 0; j < C; ++j) {
				if (taken[i][j]) continue;
				val = lawn[i][j];
				set.add(lawn[i][j]);
			}
			if (set.size() == 1 && val == h)
				for (int j = 0; j < C; ++j)
					taken[i][j] = true;
		}
		
		for (int j = 0; j < C; ++j) {
			Set<Integer> set = new HashSet<Integer>();
			int val = -1;
			for (int i = 0; i < R; ++i) {
				if (taken[i][j]) continue;
				val = lawn[i][j];
				set.add(lawn[i][j]);
			}
			if (set.size() == 1 && val == h)
				for (int i = 0; i < R; ++i)
					taken[i][j] = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("B-large.in"));
		System.setOut(new PrintStream("B_out_large.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			int[][] lawn = new int[R][C];
			for (int i = 0; i < R; ++i) {
				stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < C; ++j)
					lawn[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j) {
					min = Math.min(min, lawn[i][j]);
					max = Math.max(max, lawn[i][j]);
				}
					
			
			boolean[][] taken = new boolean[R][C];
			for (int h = min; h <= max; ++h)
				mow(lawn, taken, h);
			
			boolean valid = true;
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (!taken[i][j])
						valid = false;
			System.out.println("Case #" + t + ": " + (valid ? "YES" : "NO"));
		}
		
		in.close();
		System.exit(0);
	}
}

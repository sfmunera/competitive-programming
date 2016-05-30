package codeforces;

import java.io.*;
import java.util.*;

public class Woodcutters {
	
	static class Tree {
		int x, h;
		Tree(int x, int h) {
			this.x = x;
			this.h = h;
		}
	}
	
	static Integer[][] dp;
	
	static int dp(int cur, int prev, Tree[] trees) {
		if (cur == trees.length) {
			return 0;
		}
		
		if (dp[cur][prev] != null) {
			return dp[cur][prev];
		}
		if (cur == 0) {
			return dp[cur][prev] = Math.max(Math.max(1 + dp(cur + 1, 0, trees), dp(cur + 1, 1, trees)), 1 + dp(cur + 1, 2, trees));
		} else {
			int left = prev == 2 ? trees[cur - 1].x + trees[cur - 1].h : trees[cur - 1].x;
			int right = cur < trees.length - 1 ? trees[cur + 1].x : Integer.MAX_VALUE;
			int ans = 0;
			if (left < trees[cur].x - trees[cur].h) {
				ans = Math.max(ans, 1 + dp(cur + 1, 0, trees));
			}
			ans = Math.max(ans, dp(cur + 1, 1, trees));
			if (right > trees[cur].x + trees[cur].h) {
				ans = Math.max(ans, 1 + dp(cur + 1, 2, trees));
			}
			return dp[cur][prev] = ans;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		Tree[] trees = new Tree[N];
		for (int i = 0; i < N; ++i) {
			int x = in.nextInt();
			int h = in.nextInt();
			trees[i] = new Tree(x, h);
		}
		
		dp = new Integer[N + 1][3];
		int ans = dp(0, 0, trees);
		
		System.out.println(ans);
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}

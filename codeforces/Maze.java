package codeforces;

import java.io.*;
import java.util.*;

public class Maze {
	
	static int n, m, k, cnt;
	static char[][] maze;
	static int[] di = {-1, 0, 0, 1};
	static int[] dj = {0, -1, 1, 0};
	
	static boolean inside(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}
	
	static int dfs(int i, int j, char prev, char next) {
		if (cnt == 0) return 0;
		maze[i][j] = next;
		--cnt;
		
		int ans = 1;
		for (int d = 0; d < 4; ++d) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (inside(ni, nj) && maze[ni][nj] == prev)
				ans += dfs(ni, nj, prev, next);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		
		maze = new char[n][m];
		for (int i = 0; i < n; ++i)
			maze[i] = in.next().toCharArray();
		
		boolean done = false;
		cnt = Integer.MAX_VALUE;
		for (int i = 0; i < n && !done; ++i)
			for (int j = 0; j < m && !done; ++j)
				if (maze[i][j] == '.') {
					done = true;
					int s = dfs(i, j, '.', 'X');
					
					cnt = s - k;
					dfs(i, j, 'X', '.');
				}
		
		for (int i = 0; i < n; ++i)
			System.out.println(String.valueOf(maze[i]));
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

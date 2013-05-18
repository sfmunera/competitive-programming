package uva;

import java.util.*;
import java.io.*;

public class UVa10443_RockScissorsPaper {
	
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		boolean first = true;
		while (T-- > 0) {
			int R = in.nextInt();
			int C = in.nextInt();
			int N = in.nextInt();
			
			char[][] grid = new char[R][C];
			for (int i = 0; i < R; ++i)
				grid[i] = in.nextLine().toCharArray();
			
			while (N-- > 0) {
				char[][] tmp = new char[R][C];
				for (int i = 0; i < R; ++i)
					for (int j = 0; j < C; ++j)
						tmp[i][j] = grid[i][j];
				
				for (int i = 0; i < R; ++i)
					for (int j = 0; j < C; ++j)
						for (int d = 0; d < 4; ++d) {
							int ni = i + dr[d];
							int nj = j + dc[d];
							if (inside(ni, nj, R, C)) {
								if (grid[i][j] != grid[ni][nj]) {
									if (grid[i][j] == 'R' && grid[ni][nj] == 'P')
										tmp[i][j] = 'P';
									if (grid[i][j] == 'S' && grid[ni][nj] == 'R')
										tmp[i][j] = 'R';
									if (grid[i][j] == 'P' && grid[ni][nj] == 'S')
										tmp[i][j] = 'S';
								}
							}
						}
				
				for (int i = 0; i < R; ++i)
					for (int j = 0; j < C; ++j)
						grid[i][j] = tmp[i][j];
			}
			
			if (first) first = false; else System.out.println();
			for (int i = 0; i < R; ++i)
				System.out.println(grid[i]);
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() throws IOException {
			tokenizer = null;
			return reader.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
		
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Statues {
	
	static Set<String> seen;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < 8 && c < 8;
	}
	
	static boolean dfs(char[][] b, int r, int c) {
		seen.add(toString(b));
		if (r == 0 && c == 7)
			return true;
		
		for (int dr = -1; dr <= 1; ++dr)
			for (int dc = -1; dc <= 1; ++dc) {
				int nr = r + dr;
				int nc = c + dc;
				if (inside(nr, nc) && b[nr][nc] != 'S') {
					char[][] nb = update(b, r, c, nr, nc);
					String ns = toString(nb);
					if (ns.indexOf('M') >= 0 && !seen.contains(ns) && dfs(nb, nr, nc))
						return true;
				}
			}
		return false;
	}
	
	static String toString(char[][] b) {
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < 8; ++i)
			ans.append(String.valueOf(b[i]));
		
		return ans.toString();
	}

	static char[][] update(char[][] board, int r, int c, int nr, int nc) {
		char[][] b = new char[8][8];
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j)
				b[i][j] = board[i][j];
		
		b[r][c] = '.';
		b[nr][nc] = 'M';
		for (int i = 7; i >= 0; --i)
			for (int j = 0; j < 8; ++j)
				if (b[i][j] == 'S') {
					b[i][j] = '.';
					if (i < 7)
						b[i + 1][j] = 'S';
				}
		return b;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		char[][] board = new char[8][8];
		for (int i = 0; i < 8; ++i)
			board[i] = in.next().toCharArray();
		
		seen = new HashSet<String>();
		System.out.println(dfs(board, 7, 0) ? "WIN" : "LOSE");
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}

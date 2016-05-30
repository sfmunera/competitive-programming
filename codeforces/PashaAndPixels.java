package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class PashaAndPixels {
	
	static boolean isBlack2x2(boolean[][] matrix, int r, int c, int R, int C) {
		if (r == R - 1 || c == C - 1) {
			return false;
		}
		return matrix[r][c] && matrix[r + 1][c] && matrix[r][c + 1] && matrix[r + 1][c + 1];
	}
	
	static boolean gameOver(boolean[][] matrix, int r, int c, int R, int C) {
		for (int i = r - 1; i <= r; ++i) {
			for (int j = c - 1; j <= c; ++j) {
				if (i >= 0 && j >= 0 && i < R - 1 && j < C - 1 && isBlack2x2(matrix, i, j, R, C)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		boolean[][] matrix = new boolean[n][m];
		int ans = 0;
		for (int i = 0; i < k; ++i) {
			int r = in.nextInt() - 1;
			int c = in.nextInt() - 1;
			
			matrix[r][c] = true;
			if (ans == 0) {
				if (gameOver(matrix, r, c, n, m)) {
					ans = i + 1;
				}
			}
		}
		
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

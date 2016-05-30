package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndFun {
	
	static int calcScore(int row, int[][] state) {
		int score = 0;
		int prev = 0;
		for (int i = 0; i < state[0].length; ++i) {
			if (state[row][i] == 0) {
				score = Math.max(score, i - prev);
				prev = i + 1;
			}
		}
		score = Math.max(score, state[0].length - prev);
		
		return score;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		
		int[][] state = new int[n][m];
		int[] score = new int[n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				state[i][j] = in.nextInt();
			}
			score[i] = calcScore(i, state);
		}
		
		for (int i = 0; i < q; ++i) {
			int r = in.nextInt() - 1;
			int c = in.nextInt() - 1;
			
			state[r][c] = 1 - state[r][c];
			score[r] = calcScore(r, state);
			
			int max = 0;
			for (int j = 0; j < n; ++j) {
				max = Math.max(max, score[j]);
			}
			
			sb.append(max);
			sb.append("\n");
		}
		System.out.print(sb);
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

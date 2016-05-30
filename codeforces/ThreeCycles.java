package codeforces;

import java.io.*;
import java.util.*;

public class ThreeCycles {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		boolean[][] adj = new boolean[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				boolean cycle = false;
				for (int k = 0; k < N; ++k) {
					if (adj[j][k] && adj[i][k]) {
						cycle = true;
						break;
					}
				}
				if (!cycle) {
					adj[i][j] = adj[j][i] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; ++i)
			for (int j = i + 1; j < N; ++j)
				if (adj[i][j])
					++cnt;
		System.out.println(cnt);
		for (int i = 0; i < N; ++i)
			for (int j = i + 1; j < N; ++j)
				if (adj[i][j])
					System.out.println((i + 1) + " " + (j + 1));
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

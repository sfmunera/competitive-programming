package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsAndShoelaces {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] degree = new int[n];
		boolean[][] adj = new boolean[n][n];
		
		for (int i = 0; i < m; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			++degree[a];
			++degree[b];
			adj[a][b] = adj[b][a] = true;
		}
		
		int ans = 0;
		while (true) {
			boolean changed = false;
			int[] tmp = degree.clone();
			for (int i = 0; i < n; ++i)
				if (tmp[i] == 1) {
					changed = true;
					--degree[i];
					for (int j = 0; j < n; ++j)
						if (tmp[j] > 0 && adj[i][j])
							--degree[j];
				}
			if (changed)
				++ans;
			else
				break;
		}
		System.out.println(ans);
		
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

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PoloThePenguinAndMatrix {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		int d = in.nextInt();
		
		
		int[][] mat = new int[N][M];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < M; ++j) {
				mat[i][j] = in.nextInt();
				min = Math.min(min, mat[i][j]);
			}
		
		boolean ok = true;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < M; ++j) 
				if ((mat[i][j] - min) % d != 0)
					ok = false;
		
		if (!ok)
			System.out.println(-1);
		else {
			int[] all = new int[N * M];
			int k = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < M; ++j)
					all[k++] = mat[i][j];
			
			Arrays.sort(all);
			int mid = N * M / 2;
			int ans = 0;
			for (int i = 0; i < N * M; ++i)
				ans += Math.abs(all[i] - all[mid]);
			
			System.out.println(ans / d);
		}
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

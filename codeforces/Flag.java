package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flag {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		char[][] flag = new char[N][M];
		boolean ok = true;
		for (int i = 0; i < N; ++i) {
			flag[i] = in.nextLine().toCharArray();
			if (i > 0)
				if (flag[i][0] == flag[i - 1][0]) {
					ok = false;
					break;
				}
			for (int j = 1; j < M; ++j)
				if (flag[i][j] != flag[i][0]) {
					ok = false;
					break;
				}
			if (!ok)
				break;
		}
		
		System.out.println(ok ? "YES" : "NO");
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

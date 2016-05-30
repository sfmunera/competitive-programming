package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class UVa10887_ConcatenationofLanguages {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int M = in.nextInt();
			int N = in.nextInt();
			
			String[] first = new String[M];
			String[] second = new String[N];
			for (int i = 0; i < M; ++i)
				first[i] = in.nextLine();
			for (int i = 0; i < N; ++i)
				second[i] = in.nextLine();
			
			Set<String> cat = new HashSet<String>();
			for (int i = 0; i < M; ++i)
				for (int j = 0; j < N; ++j)
					cat.add(new StringBuilder().append(first[i]).append(second[j]).toString());
			
			System.out.println("Case " + t + ": " + cat.size());
		}
		
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

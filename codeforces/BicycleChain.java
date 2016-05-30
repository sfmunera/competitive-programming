package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BicycleChain {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
		
		int m = in.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; ++i)
			b[i] = in.nextInt();
		
		int max = 0;
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				if (b[j] % a[i] == 0)
					max = Math.max(max, b[j] / a[i]);
		
		int ans = 0;
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				if (b[j] % a[i] == 0 && b[j] / a[i] == max)
					++ans;
		
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

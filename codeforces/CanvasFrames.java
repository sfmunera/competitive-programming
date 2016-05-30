package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CanvasFrames {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int[] len = new int[N];
		for (int i = 0; i < N; ++i)
			len[i] = in.nextInt();
		
		int[] cnt = new int[101];
		for (int i = 0; i < N; ++i)
			++cnt[len[i]];
		
		int ans = 0;
		
		for (int i = 0; i <= 100; ++i)
			while (cnt[i] >= 4) {
				++ans;
				cnt[i] -= 4;
			}
		
		for (int i = 0; i <= 100; ++i)
			for (int j = i + 1; j <= 100; ++j)
				while (cnt[i] >= 2 && cnt[j] >= 2) {
					++ans;
					cnt[i] -= 2;
					cnt[j] -= 2;
				}
		System.out.println(ans);
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

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GregsWorkout {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String[] muscles = {"chest", "biceps", "back"};
		int[] cnt = new int[3];
		
		int n = in.nextInt();
		for (int i = 0; i < n; ++i)
			cnt[i % 3] += in.nextInt();
		
		int maxAt = 0;
		for (int i = 1; i < 3; ++i)
			if (cnt[i] > cnt[maxAt])
				maxAt = i;
		
		System.out.println(muscles[maxAt]);
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

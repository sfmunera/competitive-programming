package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class UndoubtedlyLuckyNumbers {
	
	static Set<Long> seen;
	static int N;
	
	static void go(int i, int j, String cur) {
		long x = Long.parseLong(cur);
		if (x > N)
			return;
		if (seen.contains(x))
			return;
		seen.add(x);
		
		if (i > 0)
			go(i, j, i + cur);
		if (j > 0)
			go(i, j, j + cur);
		go(i, j, cur + i);
		go(i, j, cur + j);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		N = in.nextInt();
		
		seen = new HashSet<Long>();
		for (int i = 0; i < 10; ++i)
			for (int j = i; j < 10; ++j) {
				go(i, j, "" + i);
				go(i, j, "" + j);
				go(i, j, "" + i + j);
				go(i, j, "" + j + i);
			}
		
		System.out.println(seen.size() - 1);
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

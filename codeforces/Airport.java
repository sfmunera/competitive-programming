package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Airport {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		PriorityQueue<Integer> least = new PriorityQueue<Integer>();
		PriorityQueue<Integer> most = new PriorityQueue<Integer>();
		for (int i = 0; i < M; ++i) {
			int p = in.nextInt();
			least.offer(p);
			most.offer(-p);
		}
		
		int max = 0;
		int min = 0;
		for (int i = 0; i < N; ++i) {
			if (!most.isEmpty()) {
				int x = -most.poll();
				max += x;
				if (x - 1 > 0)
					most.offer(-(x - 1));
			}
			
			if (!least.isEmpty()) {
				int x = least.poll();
				min += x;
				if (x - 1 > 0)
					least.offer(x - 1);
			}
		}
		
		System.out.println(max + " " + min);
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

package codeforces;

import java.io.*;
import java.util.*;

public class AfterTraining {

	static class Basket implements Comparable<Basket> {
		int cnt, rank;
		double diff;
		public Basket(int cnt, double diff, int rank) {
			this.cnt = cnt;
			this.diff = diff;
			this.rank = rank;
		}
		public int compareTo(Basket b) {
			if (this.cnt != b.cnt)
				return this.cnt - b.cnt;
			if (this.diff != b.diff)
				return Double.compare(this.diff, b.diff);
			return this.rank - b.rank;
		}
		public String toString() {
			return this.cnt + " " + this.diff + " " + this.rank;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		PriorityQueue<Basket> baskets = new PriorityQueue<Basket>();
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		for (int i = 1; i <= M; ++i)
			baskets.offer(new Basket(0, Math.abs((M + 1.0) / 2.0 - i), i));
		
		for (int i = 0; i < N; ++i) {
			Basket b = baskets.poll();
			System.out.println(b.rank);
			++b.cnt;
			baskets.offer(b);
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

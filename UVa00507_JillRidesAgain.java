package uva;

import java.util.*;
import java.io.*;

public class UVa00507_JillRidesAgain {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int S = in.nextInt();
			int[] roads = new int[S - 1];
			for (int i = 0; i < S - 1; ++i)
				roads[i] = in.nextInt();
			
			int sum = 0;
			int start = 0;
			int startTmp = 0;
			int end = 0;
			int max = 0;
			for (int i = 0; i < S - 1; ++i) {
				if (sum < 0) {
					sum = 0;
					startTmp = i;
				}
				sum += roads[i];
				if (sum >= max) {
					if (sum == max) {
						// select the one with the longest run
						if (end - start > i - startTmp)
							continue;
						// if runs are equal, select the one that starts earlier
						if (end - start == i - startTmp && start < startTmp)
							continue;
					}
					max = sum;
					start = startTmp;
					end = i;
				}
			}
			
			if (max > 0)
				System.out.println("The nicest part of route " + t + " is between stops " + (start + 1) + " and " + (end + 2));
			else
				System.out.println("Route " + t + " has no nice parts");
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

package codeforces;

import java.io.*;
import java.util.*;

public class Semifinals {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		
		boolean[] hasChanceA = new boolean[n];
		boolean[] hasChanceB = new boolean[n];
		
		for (int K = 0; K <= 1; ++K) {
			int k = K * n / 2;
			for (int i = 0; i < k; ++i) {
				hasChanceA[i] = true;
				hasChanceB[i] = true;
			}
			
			int i = k;
			int j = k;
			for (int l = 0; l < n - 2 * k; ++l) {
				if (a[i] < b[j]) {
					hasChanceA[i] = true;
					++i;
				} else {
					hasChanceB[j] = true;
					++j;
				}
			}
		}
		
		StringBuilder ans1 = new StringBuilder();
		StringBuilder ans2 = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			ans1.append(hasChanceA[i] ? "1" : "0");
			ans2.append(hasChanceB[i] ? "1" : "0");
		}
		
		System.out.println(ans1);
		System.out.println(ans2);		
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
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
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}

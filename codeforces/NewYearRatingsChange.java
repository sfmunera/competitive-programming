package codeforces;

import java.io.*;
import java.util.*;

public class NewYearRatingsChange {
	
	static class Pair implements Comparable<Pair> {
		int a, ind;
		public Pair(int a, int ind) {
			this.a = a;
			this.ind = ind;
		}
		@Override
		public int compareTo(Pair p) {
			return this.a - p.a;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		Pair[] p = new Pair[n];
		
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			p[i] = new Pair(a, i);
		}
		
		Arrays.sort(p);
		
		int[] ans = new int[n];
		for (int i = 0; i < n; ++i) {
			if (i > 0 && p[i].a == p[i - 1].a) {
				ans[p[i].ind] = ans[p[i - 1].ind] + 1;
			} else {
				if (i > 0) {
					if (p[i].a > ans[p[i - 1].ind])
						ans[p[i].ind] = p[i].a;
					else
						ans[p[i].ind] = ans[p[i - 1].ind] + 1;
				} else
					ans[p[i].ind] = p[i].a;
			}
		}
		
		for (int i = 0; i < n; ++i) {
			if (i > 0) System.out.print(" ");
			System.out.print(ans[i]);
		}
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

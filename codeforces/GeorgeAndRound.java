package codeforces;

import java.io.*;
import java.util.*;

public class GeorgeAndRound {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[m];
		
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
		for (int i = 0; i < m; ++i)
			b[i] = in.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ans = 0;
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j < m && b[j] < a[i]) {
				++j;
			}
			if (j < m && b[j] >= a[i]) {
				++ans;
				++j;
			}
		}
		
		System.out.println(n - ans);
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

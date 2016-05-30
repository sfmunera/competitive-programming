package codeforces;

import java.io.*;
import java.util.*;

public class GuiltyToTheKitchen {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int V = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
			
		double min = Double.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			b[i] = in.nextInt();
			min = Math.min(min, (double) b[i] / a[i]);
		}
		
		double ans = 0.0;
		for (int i = 0; i < n; ++i)
			ans += a[i] * min;
		
		ans = Math.min(ans, V);
		System.out.println(ans);
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

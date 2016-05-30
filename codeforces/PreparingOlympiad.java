package codeforces;

import java.io.*;
import java.util.*;

public class PreparingOlympiad {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		int x = in.nextInt();
		
		int[] c = new int[n];
		for (int i = 0; i < n; ++i) {
			c[i] = in.nextInt();
		}
		
		int ans = 0;
		for (int mask = 0; mask < (1 << n); ++mask) {
			int cnt = 0;
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int i = 0; i < n; ++i) {
				if ((mask & (1 << i)) > 0) {
					++cnt;
					sum += c[i];
					min = Math.min(min, c[i]);
					max = Math.max(max, c[i]);
				}
			}
			
			if (cnt >= 2 && sum >= l && sum <= r && max - min >= x) {
				++ans;
			}
		}
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

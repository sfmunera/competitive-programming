package codeforces;

import java.io.*;
import java.util.*;

public class GameWithCoins {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n + 1];
		
		for (int i = 1; i <= n; ++i)
			a[i] = in.nextInt();
		
		if (n % 2 == 0 || n < 3)
			System.out.println(-1);
		else {
			int ans = 0;
			for (int i = n; i >= 2; --i) {
				int x = i / 2;
				int max = a[i];
				ans += max;
				a[x] = Math.max(0, a[x] - max);
				a[2 * x] = Math.max(0, a[2 * x] - max);
				a[2 * x + 1] = Math.max(0, a[2 * x + 1] - max);
			}
			
			for (int i = 0; i < n; ++i)
				if (a[i] > 0)
					ans += a[i];

			System.out.println(ans);
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

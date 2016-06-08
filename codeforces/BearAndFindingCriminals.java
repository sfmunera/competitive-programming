package codeforces;

import java.io.*;
import java.util.*;

public class BearAndFindingCriminals {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int a = in.nextInt() - 1;
		
		int[] t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = in.nextInt();
		}
		
		int ans = t[a];
		for (int d = 1; a - d >= 0 || a + d < n; ++d) {
			if (a - d >= 0 && a + d < n) {
				ans += t[a - d] == 1 && t[a + d] == 1 ? 2 : 0;
			} else if (a - d >= 0) {
				ans += t[a - d];
			} else if (a + d < n) {
				ans += t[a + d];
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

package codeforces;

import java.io.*;
import java.util.*;

public class SeaAndIslands {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		if (k > (n * n + 1) / 2) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (k > 0 && (i + j) % 2 == 0) {
						--k;
						ans.append("L");
					} else {
						ans.append("S");
					}
				}
				ans.append("\n");
			}
			System.out.print(ans);
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

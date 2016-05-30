package codeforces;

import java.io.*;
import java.util.*;

public class NewYearPresent {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (a[i] == 0 && i < n - 1)
				ans.append("R");
			while (a[i] > 0) {
				ans.append("P");
				if (i == n - 1 && a[i] == 1)
					break;
				ans.append(i < n - 1 ? "R" : "L");
				if (a[i] > 1)
					ans.append(i < n - 1 ? "L" : "R");
				--a[i];
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

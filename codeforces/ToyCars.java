package codeforces;

import java.io.*;
import java.util.*;

public class ToyCars {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i <= N; ++i) {
			boolean isGood = true;
			for (int j = 0; j < N; ++j) {
				int crash = in.nextInt();
				if (i != j + 1) {
					if (crash == 1 || crash == 3) {
						isGood = false;
					}
				}
			}
			if (isGood) {
				ans.add(i);
			}
		}
		
		System.out.println(ans.size());
		if (ans.size() > 0) {
			for (int i = 0; i < ans.size(); ++i) {
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(ans.get(i));
			}
			System.out.println();
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

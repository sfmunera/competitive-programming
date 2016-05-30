package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class GuessYourWayOut {

	static long go(long h, long n, boolean left) {
		if (h == 0) {
			return 0;
		}
		
		long numChildren = (1L << h) - 1;
		long numLeaves = (1L << (h - 1));

		long ans = 0;
		if (left) {
			if (n > numLeaves) {
				ans = numChildren;
			} else {
				ans = 1;
				--h;
			}
		} else {
			if (n > numLeaves) {
				ans = 1;
				n -= numLeaves;
				--h;
			} else {
				ans = numChildren;
			}
		}
		
		return ans + go(h, n, !left);
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		long h = in.nextLong();
		long n = in.nextLong();
		
		long ans = go(h, n, true);
		
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

package codeforces;

import java.io.*;
import java.util.*;

public class InnaAndPinkPony {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int R = in.nextInt();
		int C = in.nextInt();
		int r = in.nextInt();
		int c = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int diffr1 = Math.abs(r - 1);
		int diffr2 = Math.abs(R - r);
		int diffc1 = Math.abs(c - 1);
		int diffc2 = Math.abs(C - c);

		int ans = Integer.MAX_VALUE;
		if ((r == 1 || r == R) && (c == 1 || c == C)) ans = 0;
		else {
			if (diffr1 % a == 0 && diffc1 % b == 0 && (diffr1 / a) % 2 == (diffc1 / b) % 2)
				ans = Math.min(ans, Math.max(diffr1 / a, diffc1 / b));
			if (diffr1 % a == 0 && diffc2 % b == 0 && (diffr1 / a) % 2 == (diffc2 / b) % 2)
				ans = Math.min(ans, Math.max(diffr1 / a, diffc2 / b));
			if (diffr2 % a == 0 && diffc1 % b == 0 && (diffr2 / a) % 2 == (diffc1 / b) % 2)
				ans = Math.min(ans, Math.max(diffr2 / a, diffc1 / b));
			if (diffr2 % a == 0 && diffc2 % b == 0 && (diffr2 / a) % 2 == (diffc2 / b) % 2)
				ans = Math.min(ans, Math.max(diffr2 / a, diffc2 / b));
			
			if (a >= R || b >= C) ans = Integer.MAX_VALUE;
		}
		System.out.println(ans == Integer.MAX_VALUE ? "Poor Inna and pony!" : ans);
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

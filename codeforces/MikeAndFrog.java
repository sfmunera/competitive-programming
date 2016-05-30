package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndFrog {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}

	static boolean checkNumber(int h, int x, int y, int a, int mod) {
		Set<Integer> seen = new HashSet<Integer>();
		seen.add(h);
		while (true) {
			long val = h;
			val *= (long) x;
			val %= mod;
			val += (long) y;
			val %= mod;
			h = (int) val;
			
			if (h == a) {
				return true;
			}
			if (seen.contains(h)) {
				return false;
			}
			seen.add(h);
		}
	}
	
	static int cycleLength(int h, int x, int y, int a, int mod) {
		int pos = -1;
		for (int i = 1; ; ++i) {
			long val = h;
			val *= (long) x;
			val %= mod;
			val += (long) y;
			val %= mod;
			h = (int) val;
			
			if (h == a) {
				if (pos == -1) {
					pos = i;
				} else {
					return i - pos;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int m = in.nextInt();
		int h1 = in.nextInt();
		int a1 = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		
		int h2 = in.nextInt();
		int a2 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();

		long ans = -1;
		if (checkNumber(h1, x1, y1, a1, m) && checkNumber(h2, x2, y2, a2, m)) {
			int cycle1 = cycleLength(h1, x1, y1, a1, m);
			int cycle2 = cycleLength(h2, x2, y2, a2, m);
			ans = lcm((long) cycle1, (long) cycle2);
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

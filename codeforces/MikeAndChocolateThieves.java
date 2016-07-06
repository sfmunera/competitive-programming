package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndChocolateThieves {
	
	static long[] cubes;
	
	static long can(long n, long m) {
		int low = 0;
		int high = cubes.length - 1;
		
		int k = 0;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (cubes[middle] <= n) {
				low = middle + 1;
				k = middle;
			} else {
				high = middle - 1;
			}
		}
		
		long cnt = 0;
		for (int i = 2; i <= k; ++i) {
			cnt += n / cubes[i];
		}
		
		return cnt - m;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		cubes = new long[1000001];
		for (int i = 0; i < cubes.length; ++i) {
			cubes[i] = (long) i * i * i;
		}
				
		long m = in.nextLong();
		
		long lo = 1;
		long hi = Long.MAX_VALUE / 2;
		
		long n = -1;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			
			long can = can(mid, m);
			if (can == 0L) {
				n = mid;
			}
			
			if (can >= 0L) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		
		System.out.println(n);
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

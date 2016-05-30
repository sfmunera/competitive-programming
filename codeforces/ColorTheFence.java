package codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ColorTheFence {
	
	static int[] a;
	static BigInteger[] dp;
	
	static BigInteger dp(int v) {
		if (v <= 0) {
			return BigInteger.ZERO;
		}
		
		if (dp[v] != null)
			return dp[v];
		
		BigInteger ans = BigInteger.ZERO;
		for (int d = 1; d <= 9; ++d) {
			if (v >= a[d]) {
				ans = ans.max(dp(v - a[d]).multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(d)));
			}
		}
		
		return dp[v] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int v = in.nextInt();
		
		a = new int[10];
		for (int i = 1; i <= 9; ++i)
			a[i] = in.nextInt();
		
		/*dp = new BigInteger[v + 1];
		
		BigInteger ans = dp(v);
		System.out.println(ans.equals(BigInteger.ZERO) ? -1 : ans);*/
		
		int max = 0;
		int maxd = 0;
		for (int d = 1; d <= 9; ++d) {
			if (v / a[d] > max) {
				max = v / a[d];
				maxd = d;
			}
		}
		
		int sum = max * a[maxd];
		
		StringBuilder tmp = new StringBuilder();
		for (int i = 0; i < max; ++i) {
			for (int d = 9; d >= maxd; --d) {
				if (sum - a[maxd] + a[d] <= v) {
					tmp.append(d);
					sum = sum - a[maxd] + a[d];
					break;
				}
			}
		}
		
		String ans = tmp.toString();
		System.out.println(ans.isEmpty() ? -1 : ans);
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

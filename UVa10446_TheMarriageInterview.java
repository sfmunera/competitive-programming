package uva;

import java.io.*;
import java.util.*;
import java.math.*;

public class UVa10446_TheMarriageInterview {
	
	static final int MAX_VAL = 60;
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		
		BigInteger[][] dp = new BigInteger[MAX_VAL + 1][MAX_VAL + 1];
		for (int back = 0; back <= MAX_VAL; ++back) {
			Arrays.fill(dp[back], BigInteger.valueOf(back));
			dp[back][0] = dp[back][1] = BigInteger.ONE;
			
			for (int i = 1; i <= MAX_VAL; ++i)
				for (int j = 1; j <= back && i - j > 1; ++j)
					dp[back][i] = dp[back][i].add(dp[back][i - j]);
		}
		
		int t = 1;
		while (true) {
			int n = in.nextInt();
			int back = in.nextInt();
			
			if (n > 60)
				break;
			
			BigInteger ans = BigInteger.ONE;
			if (n > 1) {
				back = Math.max(0, back);
				ans = dp[back][n].add(BigInteger.ONE);
			}
			System.out.println("Case " + t + ": " + ans);
			++t;
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

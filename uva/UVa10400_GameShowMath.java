package uva;

import java.io.*;
import java.util.*;

public class UVa10400_GameShowMath {
	
	static int n, t;
	static int[] numbers;
	static String sequence;
	static final String signs = "/+-*";
	static int[][] dp;
	
	static boolean inRange(int v) {
		return v > -32000 && v < 32000;
	}
	
	static int newValue(int cur, int x, char op) {
		if (op == '/') return cur / x;
		if (op == '+') return cur + x;
		if (op == '-') return cur - x;
		if (op == '*') return cur * x;
		return 0;
	}
	
	static int go(int i, int cur, String ops) {
		if (i == n) {
			if (cur == t) sequence = ops;
			return cur == t ? 1 : 0;
		}
		
		if (dp[i][cur + (1 << 15)] != -1) return dp[i][cur + (1 << 15)];
		
		int ans = 0;
		for (int j = 0; j < signs.length(); ++j) {
			if (signs.charAt(j) == '/' && cur % numbers[i] != 0)
				continue;
			int val = newValue(cur, numbers[i], signs.charAt(j));
			if (inRange(val))
				ans |= go(i + 1, val, ops + signs.charAt(j));
		}

		return dp[i][cur + (1 << 15)] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		StringBuilder output = new StringBuilder();
		
		int T = in.nextInt();
		while (T-- > 0) {
			n = in.nextInt();
			numbers = new int[n];
			for (int i = 0; i < n; ++i)
				numbers[i] = in.nextInt();
			t = in.nextInt();
			
			sequence = "";
			dp = new int[n + 1][1 << 16];
			for (int i = 0; i <= n; ++i)
				Arrays.fill(dp[i], -1);
			
			boolean possible = go(1, numbers[0], "") == 1;
			if (!possible)
				output.append("NO EXPRESSION\n");
			else {
				output.append(numbers[0]);
				for (int i = 1; i < n; ++i)
					output.append("" + sequence.charAt(i - 1) + numbers[i]);
				output.append("=" + t + "\n");
			}
		}
		System.out.print(output);
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

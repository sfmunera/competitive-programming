package uva;

import java.io.*;
import java.util.*;

public class UVa10912_SimpleMindedHashing {
	
	static Integer[][][] dp;
	
	static int go(int lettersLeft, int sumRemaining, int previousLetter) {
		if (sumRemaining < 0)
			return 0;
		if (lettersLeft == 0 && sumRemaining == 0)
			return 1;
		if (lettersLeft == 0 && sumRemaining > 0)
			return 0;
		
		if (dp[lettersLeft][sumRemaining][previousLetter] != null)
			return dp[lettersLeft][sumRemaining][previousLetter];
		
		int ans = 0;
		for (int c = previousLetter + 1; c <= 26; ++c)
			ans += go(lettersLeft - 1, sumRemaining - c, c);
		
		return dp[lettersLeft][sumRemaining][previousLetter] = ans;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t = 1;
		while (true) {
			int L = in.nextInt();
			int S = in.nextInt();
			if (L == 0 && S == 0)
				break;
			
			int ans = 0;
			if (L <= 26 && S <= (26 * 27) / 2) {
				/*dp = new int[L + 1][S + 1][27];
				for (int i = 0; i <= 26; ++i)
					dp[0][0][i] = 1;
				for (int i = 1; i <= L; ++i)
					for (int j = 0; j <= S; ++j)
						for (int k = 26; k >= 0; --k)
							for (int c = k + 1; c <= 26 && j >= c; ++c)
								dp[i][j][k] += dp[i - 1][j - c][c];
				ans = dp[L][S][0];*/
				
				dp = new Integer[L + 1][S + 1][27];
				ans = go(L, S, 0);
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

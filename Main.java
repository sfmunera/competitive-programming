import java.util.*;
import java.io.*;

public class Main {
	
	static final int[] values = {1, 5, 10, 25, 50};
	static Integer[][] dp;
	
	static int dp(int i, int N) {
		if (N < 0) return 0;
		if (N == 0) return 1;
		if (i == values.length) return 0;
		
		if (dp[i][N] != null) return dp[i][N];
		
		return dp[i][N] = dp(i, N - values[i]) + dp(i + 1, N);
	}

	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			
			dp = new Integer[5][N + 5];
			int ans = dp(0, N);
			
			System.out.println("Hay " + ans + " forma(s) de pagar " + N + " mil pesos");
		}
		
		System.exit(0);
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
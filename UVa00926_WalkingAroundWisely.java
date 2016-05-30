package uva;

import java.io.*;
import java.util.*;

public class UVa00926_WalkingAroundWisely {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int Ax = in.nextInt() - 1;
			int Ay = in.nextInt() - 1;
			int Bx = in.nextInt() - 1;
			int By = in.nextInt() - 1;
			
			String[][] blocked = new String[N][N];
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					blocked[i][j] = "";
			
			int W = in.nextInt();
			for (int i = 0; i < W; ++i) {
				int Px = in.nextInt() - 1;
				int Py = in.nextInt() - 1;
				char D = in.next().charAt(0);
				
				blocked[Py][Px] += D;
			}
			
			long[][] dp = new long[N][N];
			dp[Ay][Ax] = 1;
			for (int y = Ay; y <= By; ++y)
				for (int x = Ax; x <= Bx; ++x) {
					if (y < N - 1 && !blocked[y][x].contains("N") && !blocked[y + 1][x].contains("S"))
						dp[y + 1][x] += dp[y][x];
					if (x < N - 1 && !blocked[y][x].contains("E") && !blocked[y][x + 1].contains("W"))
						dp[y][x + 1] += dp[y][x];
				}
			
			System.out.println(dp[By][Bx]);
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

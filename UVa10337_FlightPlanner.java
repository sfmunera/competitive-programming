package uva;

import java.io.*;
import java.util.*;

public class UVa10337_FlightPlanner {
	
	static int X;
	static int[][] windStrength;
	static long[][] dp;
	
	static final int MAX_ALTITUDE = 9;
	static final int COST_CLIMB = 60;
	static final int COST_HOLD = 30;
	static final int COST_SINK = 20;
	
	static long go(int currentAltitude, int milesSoFar) {
		if (milesSoFar > 0 && milesSoFar < X && currentAltitude == 0)
			return Integer.MAX_VALUE / 2;
		if (milesSoFar == X && currentAltitude > 0)
			return Integer.MAX_VALUE / 2;
		if (milesSoFar == X && currentAltitude == 0)
			return 0;
		
		if (dp[currentAltitude][milesSoFar] != -1)
			return dp[currentAltitude][milesSoFar];
		
		long ans = go(currentAltitude, milesSoFar + 1) + COST_HOLD;
		if (currentAltitude < MAX_ALTITUDE)
			ans = Math.min(ans, go(currentAltitude + 1, milesSoFar + 1) + COST_CLIMB);
		if (currentAltitude > 0)
			ans = Math.min(ans, go(currentAltitude - 1, milesSoFar + 1) + COST_SINK);
		
		return dp[currentAltitude][milesSoFar] = ans - windStrength[currentAltitude][milesSoFar];
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		
		while (T-- > 0) {
			X = in.nextInt();
			X /= 100;
			windStrength = new int[MAX_ALTITUDE + 1][X];
			
			for (int i = 0; i <= MAX_ALTITUDE; ++i)
				for (int j = 0; j < X; ++j)
					windStrength[MAX_ALTITUDE - i][j] = in.nextInt();
			
			dp = new long[MAX_ALTITUDE + 2][X + 1];
			for (int i = 0; i <= MAX_ALTITUDE + 1; ++i)
				Arrays.fill(dp[i], -1);
			
			// (milesLeft, currentAltitude)
			System.out.println(go(0, 0));
			System.out.println();
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

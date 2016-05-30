package codeforces;

import java.io.*;
import java.util.*;

public class HaarFeatures {
	
	static boolean solved(boolean[][] feature) {
		for (int i = 0; i < feature.length; ++i) {
			for (int j = 0; j < feature[0].length; ++j) {
				if (feature[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void updateFeature(boolean[][] feature, int row, int col) {
		for (int i = 0; i <= row; ++i) {
			for (int j = 0; j <= col; ++j) {
				feature[i][j] = !feature[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		boolean[][] feature = new boolean[n][m];
		for (int i = 0; i < n; ++i) {
			String line = in.next();
			for (int j = 0; j < m; ++j) {
				feature[i][j] = line.charAt(j) == 'W';
			}
		}
		
		int ans = 0;
		while (!solved(feature)) {
			int rightMost = 0;
			for (int j = 0; j < m; ++j) {
				for (int i = 0; i < n; ++i) {
					if (feature[i][j]) {
						rightMost = j;
					}
				}
			}
			
			int row = 0;
			for (int i = 0; i < n; ++i) {
				if (feature[i][rightMost]) {
					row = i;
				}
			}
			
			System.out.println("update " + row + ", " + rightMost);
			updateFeature(feature, row, rightMost);
			for (int i = 0; i < n; ++i) {
				System.out.println(Arrays.toString(feature[i]));
			}
			++ans;
			
			if (solved(feature)) {
				break;
			}
			
			int lowMost = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (feature[i][j]) {
						lowMost = i;
					}
				}
			}
			
			int col = 0;
			for (int j = 0; j < m; ++j) {
				if (feature[lowMost][j]) {
					col = j;
				}
			}
			
			System.out.println("update " + lowMost + ", " + col);
			updateFeature(feature, lowMost, col);
			for (int i = 0; i < n; ++i) {
				System.out.println(Arrays.toString(feature[i]));
			}
			++ans;
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

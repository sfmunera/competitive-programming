package codeforces;

import java.io.*;
import java.util.*;

public class MikeAndCellphone {
	
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Pair getPosition(int x) {
		switch (x) {
		case 0: return new Pair(3, 1);
		case 1: return new Pair(0, 0);
		case 2: return new Pair(0, 1);
		case 3: return new Pair(0, 2);
		case 4: return new Pair(1, 0);
		case 5: return new Pair(1, 1);
		case 6: return new Pair(1, 2);
		case 7: return new Pair(2, 0);
		case 8: return new Pair(2, 1);
		case 9: return new Pair(2, 2);
		default: return new Pair(-1, -1);
		}
	}
	
	static boolean unique(boolean[][] marked, int dr, int dc) {		
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (!marked[i][j]) continue;
				int nr = i + dr;
				int nc = j + dc;
				
				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 3) return true;
				if ((nr == 3 && nc == 0) || (nr == 3 && nc == 2)) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		String seq = in.next();
		
		boolean[][] marked = new boolean[4][3];
		
		for (char c : seq.toCharArray()) {
			Pair pos = getPosition(c - '0');
			marked[pos.x][pos.y] = true;
		}

		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		boolean unique = true;
		for (int i = 0; i < 4; ++i) {
			unique &= unique(marked, dr[i], dc[i]);
		}
		
		System.out.println(unique ? "YES" : "NO");
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

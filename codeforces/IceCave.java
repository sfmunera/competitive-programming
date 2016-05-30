package codeforces;

import java.io.*;
import java.util.*;

public class IceCave {
	
	static class State {
		int r, c;
		public State(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int rows = in.nextInt();
		int cols = in.nextInt();
		
		char[][] field = new char[rows][cols];
		for (int i = 0; i < rows; ++i) {
			field[i] = in.next().toCharArray();
		}
		
		int r1 = in.nextInt() - 1;
		int c1 = in.nextInt() - 1;
		int r2 = in.nextInt() - 1;
		int c2 = in.nextInt() - 1;
		
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		Queue<State> Q = new LinkedList<State>();
		boolean[][] seen = new boolean[rows][cols];
		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < cols; ++j) {
				if (field[i][j] == 'X') {
					seen[i][j] = true;
				}
			}
		
		Q.offer(new State(r1, c1));		
		boolean exists = false;
		while (!Q.isEmpty()) {
			State state = Q.poll();
			for (int i = 0; i < 4; ++i) {
				int nr = state.r + dr[i];
				int nc = state.c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {
					if (!seen[nr][nc]) {
						seen[nr][nc] = true;
						Q.offer(new State(nr, nc));
					} else {
						if (nr == r2 && nc == c2) {
							exists = true;
						}
					}
				}
			}
		}
		
		System.out.println(exists ? "YES" : "NO");
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

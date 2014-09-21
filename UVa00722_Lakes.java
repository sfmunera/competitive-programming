package uva;

import java.io.*;
import java.util.*;

public class UVa00722_Lakes {
	
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, -1, 1, 0};
	
	static boolean[][] field;
	static boolean[][] seen;
	static int R, C;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static int dfs(int r, int c) {
		seen[r][c] = true;
		
		int cnt = 1;
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc) && !seen[nr][nc] && field[nr][nc])
				cnt += dfs(nr, nc);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		in.nextLine();
		
		boolean first = true;
		while (T-- > 0) {
			int sr = in.nextInt();
			int sc = in.nextInt();
			ArrayList<String> input = new ArrayList<String>();
			String line;
			while ((line = in.nextLine()) != null) {
				line = line.trim();
				if (line.isEmpty())
					break;
				input.add(line);
			}
			
			R = input.size() + 2;
			C = input.get(0).length() + 2;
			
			field = new boolean[R][C];
			seen = new boolean[R][C];
			for (int i = 0; i < R - 2; ++i)
				for (int j = 0; j < C - 2; ++j)
					if (input.get(i).charAt(j) == '0')
						field[i + 1][j + 1] = true;

			if (first) first = false; else System.out.println();
			System.out.println(dfs(sr, sc));
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}

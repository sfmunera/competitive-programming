package uva;

import java.util.*;
import java.io.*;

public class UVa00710_TheGame {

	static final int[] dr = {-1, 0, 0, 1}; // NWES
	static final int[] dc = {0, -1, 1, 0};
	static int R, C;
	static char[][] board;

	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R + 2 && c < C + 2;
	}

	static class Item {
		int r, c, d;
		public Item(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int bfs(int rs, int cs, int rt, int ct) {
		Queue<Item> Q = new LinkedList<Item>();
		boolean[][][] seen = new boolean[R + 2][C + 2][5];
		int[][][] dist = new int[R + 2][C + 2][5];

		for (int i = 0; i < R + 2; ++i)
			for (int j = 0; j < C + 2; ++j)
				for (int k = 0; k < 5; ++k)
					dist[i][j][k] = -1;

		Q.offer(new Item(rs, cs, 4));
		seen[rs][cs][4] = true;
		dist[rs][cs][4] = 0;

		while (!Q.isEmpty()) {
			Item it = Q.poll();
			int r = it.r;
			int c = it.c;
			int prevDir = it.d;
			if (r == rt && c == ct)
				return dist[r][c][prevDir];
			for (int d = 0; d < 4; ++d) {
				if (d == prevDir)
					continue;
				for (int k = 1; ; ++k) {
					int nr = r + k * dr[d];
					int nc = c + k * dc[d];
					if (!inside(nr, nc) || board[nr][nc] == 'X')
						break;
					if (!seen[nr][nc][d]) {
						seen[nr][nc][d] = true;
						dist[nr][nc][d] = dist[r][c][prevDir] + 1;
						Q.offer(new Item(nr, nc, d));
					}	
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int t = 1;
		while (true) {
			C = in.nextInt();
			R = in.nextInt();

			if (R == 0 && C == 0)
				break;

			board = new char[R + 2][C + 2];
			Arrays.fill(board[0], ' ');
			Arrays.fill(board[R + 1], ' ');
			for (int i = 1; i <= R; ++i) {
				String line = in.nextLine();
				line = " " + line + " ";
				board[i] = line.toCharArray();
			}

			System.out.println("Board #" + t + ":");

			int m = 1;
			while (true) {
				int c1 = in.nextInt();
				int r1 = in.nextInt();
				int c2 = in.nextInt();
				int r2 = in.nextInt();

				if (c1 == 0 && r1 == 0 && c2 == 0 && r2 == 0)
					break;

				char tmp = board[r2][c2];
				board[r2][c2] = 'O';

				int ans = bfs(r1, c1, r2, c2);
				System.out.println("Pair " + m + ": " + (ans == -1 ? "impossible." : ans + " segments."));
				++m;

				board[r2][c2] = tmp;
			}
			System.out.println();
			++t;
		}		

		System.exit(0);
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

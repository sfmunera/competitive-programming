package uva;

import java.util.*;
import java.io.*;

public class UVa10309_TurntheLightsOff {
//public class Main {

	static int[] dr = {0, -1, 0, 0, 1};
	static int[] dc = {0, 0, -1, 1, 0};

	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < 10 && c < 10;
	}

	static void flip(int[] b, int r, int c) {
		for (int d = 0; d < 5; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc))
				b[nr] ^= (1 << nc);
		}
	}

	static boolean solved(int[] b) {
		for (int i = 0; i < 10; ++i)
			if (b[i] > 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		while (true) {
			String name = in.nextLine();
			if (name.equals("end"))
				break;

			int[] board = new int[10];
			for (int i = 0; i < 10; ++i) {
				String line = in.nextLine();
				for (int j = 0; j < 10; ++j)
					if (line.charAt(j) == 'O')
						board[i] |= (1 << j);
			}
			int ans = Integer.MAX_VALUE;

			for (int mask = 0; mask < (1 << 10); ++mask) {
				int[] b = board.clone();
				for (int j = 0; j < 10; ++j)
					if ((mask & (1 << j)) > 0)
						flip(b, 0, j);
				int cnt = Integer.bitCount(mask);
				for (int i = 1; i < 10; ++i)
					for (int j = 0; j < 10; ++j)
						if ((b[i - 1] & (1 << j)) > 0) {
							++cnt;
							flip(b, i, j);
						}
				if (solved(b))
					ans = Math.min(ans, cnt);
			}

			System.out.println(name + " " + ans);
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

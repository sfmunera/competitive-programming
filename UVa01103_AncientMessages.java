package uva;

import java.util.*;
import java.io.*;

public class UVa01103_AncientMessages {
	
	static int[] dh = {-1, 0, 0, 1};
	static int[] dw = {0, -1, 1, 0};
	static int[][] mat;
	static int H, W;
	static boolean[][] seen;
	
	static boolean inside(int h, int w) {
		return h >= 0 && w >= 0 && h < H && w < W;
	}
	
	static void dfs(int hs, int ws) {
		Stack<Integer> Sh = new Stack<Integer>();
		Stack<Integer> Sw = new Stack<Integer>();
		
		Sh.push(hs);
		Sw.push(ws);
		seen[hs][ws] = true;
		
		while (!Sh.isEmpty()) {
			int h = Sh.pop();
			int w = Sw.pop();
			for (int d = 0; d < 4; ++d) {
				int nh = h + dh[d];
				int nw = w + dw[d];
				
				if (inside(nh, nw) && !seen[nh][nw] && mat[nh][nw] == 0) {
					seen[nh][nw] = true;
					Sh.push(nh);
					Sw.push(nw);
				}
			}
		}
	}
	
	static int dfs2(int hs, int ws) {
		Stack<Integer> Sh = new Stack<Integer>();
		Stack<Integer> Sw = new Stack<Integer>();
		
		Sh.push(hs);
		Sw.push(ws);
		seen[hs][ws] = true;
		
		int cnt = 0;
		while (!Sh.isEmpty()) {
			int h = Sh.pop();
			int w = Sw.pop();
			for (int d = 0; d < 4; ++d) {
				int nh = h + dh[d];
				int nw = w + dw[d];
				
				if (inside(nh, nw) && !seen[nh][nw]) {
					if (mat[nh][nw] == 1) {
						seen[nh][nw] = true;
						Sh.push(nh);
						Sw.push(nw);
					} else {
						++cnt;
						dfs(nh, nw);
					}
				}
			}
		}
		
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		String hex = "0123456789abcdef";
		String hieroglyphs = "WAKJSD";
		int t = 1;
		
		while (true) {
			H = in.nextInt();
			W = in.nextInt();
			
			if (H == 0 && W == 0)
				break;
			
			W *= 4;
			
			mat = new int[H][W];
			seen = new boolean[H][W];
			for (int i = 0; i < H; ++i) {
				String line = in.next();
				for (int j = 0; j < W / 4; ++j) {
					String bin = Integer.toBinaryString(hex.indexOf(line.charAt(j)));
					int l = 4 * (j + 1) - 1;
					for (int k = bin.length() - 1; k >= 0; --k)
						mat[i][l--] = bin.charAt(k) - '0';
				}
			}
			
			for (int i = 0; i < H; ++i) {
				if (!seen[i][0] && mat[i][0] == 0)
					dfs(i, 0);
				if (!seen[i][W - 1] && mat[i][W - 1] == 0)
					dfs(i, W - 1);
			}
			for (int j = 0; j < W; ++j) {
				if (!seen[0][j] && mat[0][j] == 0)
					dfs(0, j);
				if (!seen[H - 1][j] && mat[H - 1][j] == 0)
					dfs(H - 1, j);
			}

			String ans = "";
			for (int i = 0; i < H; ++i)
				for (int j = 0; j < W; ++j)
					if (mat[i][j] == 1 && !seen[i][j]) {
						int cnt = dfs2(i, j);
						ans += hieroglyphs.charAt(cnt);
					}
			
			char[] ansc = ans.toCharArray();
			Arrays.sort(ansc);
			System.out.println("Case " + t + ": " + String.valueOf(ansc));
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

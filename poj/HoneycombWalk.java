package poj;

import java.io.*;

public class HoneycombWalk {
	static int[] dr = {-1, -1, 0, 0, 1, 1};
	static int[] dc = {-1, 0, -1, 1, 0, 1};
	static final int R = 17;
	static final int C = 17;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static long[][] multiply(long[][] a, long[][] b) {
		long[][] c = new long[R * C][R * C]; 
		
		for (int i = 0; i < R * C; ++i)
			for (int j = 0; j < R * C; ++j)
				for (int k = 0; k < R * C; ++k)
					c[i][j] += a[i][k] * b[k][j];
		return c;
	}
	
	static long[][] eye() {
		long[][] I = new long[R * C][R * C];
		for (int i = 0; i < R * C; ++i)
			I[i][i] = 1;
		return I;
	}
	
	static long[][] fastPow(long[][] m, int N) {
		if (N == 0)
			return eye();
		if (N == 1)
			return m;
		if (N % 2 == 1)
			return multiply(m, fastPow(m, N - 1));
		else {
			long[][] tmp = fastPow(m, N / 2);
			return multiply(tmp, tmp);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/*int[][] mat = new int[R][C];
		int k = 0;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				mat[i][j] = k++;
		
		long[][] adj = new long[R * C][R * C];
		
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				for (int d = 0; d < 6; ++d) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (!inside(nr, nc))
						continue;
					adj[mat[i][j]][mat[nr][nc]] = 1;
					adj[mat[nr][nc]][mat[i][j]] = 1;
				}
		
		long[] ans = new long[15];
		for (int i = 0; i <= 14; ++i) {
			long[][] a = fastPow(adj, i);
			ans[i] = a[144][144];
		}*/
		
		long[] ans = {1, 0, 6, 12, 90, 360, 2040, 10080, 54810, 290640, 1588356, 8676360, 47977776, 266378112, 1488801600};

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			
			System.out.println(ans[N]);
		}
	}
}

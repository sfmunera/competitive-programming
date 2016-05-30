package livearchive;

import java.util.*;
import java.io.*;

public class Pebbles {
	
	static boolean inside(int r, int c, int N) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static boolean canPutPebble(boolean[][] used, int r, int c) {
		int[] dr = {-1, -1, -1, 0};
		int[] dc = {-1, 0, 1, -1};
		
		for (int d = 0; d < dr.length; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!inside(nr, nc, used.length))
				continue;
			if (used[nr][nc])
				return false;
		}
		return true;
	}
	
	static int solveHelper(int[][] mat, boolean[][] used, int r, int c) {
		int N = mat.length;
		if (r >= N) return 0;
		
		int nr = c + 1 < N ? r : r + 1;
		int nc = c + 1 < N ? c + 1 : 0;
		// Case 1: put pebble here
		int ans1 = 0;
		if (canPutPebble(used, r, c)) {
			used[r][c] = true;
			ans1 = mat[r][c] + solveHelper(mat, used, nr, nc);
			used[r][c] = false;
		}
		
		// Case 2: do not put pebble here
		int ans2 = solveHelper(mat, used, nr, nc);
		
		return Math.max(ans1, ans2);
	}
	
	static int solve(int[][] mat) {
		int N =  mat.length;
		boolean[][] used = new boolean[N][N];
		return solveHelper(mat, used, 0, 0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean done = false;
		while (!done) {
			String line;
			List<String> lines = new ArrayList<String>();
			while (true) {
				line = in.readLine();
				if (line == null || line.isEmpty()) {
					done = line == null;
					break;
				}
				lines.add(line);
			}
			
			int N = lines.size();
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(lines.get(i));
				for (int j = 0; j < N; ++j) {
					mat[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			System.out.println(solve(mat));
		}
		
		in.close();
		System.exit(0);
	}
}

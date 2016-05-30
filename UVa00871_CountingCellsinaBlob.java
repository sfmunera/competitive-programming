package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 812 (871 - Counting Cells in a Blob) */
/* SUBMISSION: 09432717 */
/* SUBMISSION TIME: 2011-11-02 01:35:08 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00871_CountingCellsinaBlob {
	
	static int N;
	static boolean[][] visited;
	static char[][] board;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static int dfs(int r, int c) {
		
		visited[r][c] = true;
		int cnt = 0;
		
		for (int d = 0; d < 8; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (inside(nr, nc) && !visited[nr][nc] && board[nr][nc] == '1')
				cnt += dfs(nr, nc);
		}
		return 1 + cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			String line;
			board = new char[26][26];
			N = 0;
			
			while ((line = in.readLine()) != null) {
				if (line.isEmpty())
					break;
				board[N++] = line.toCharArray();
			}
			visited = new boolean[N][N];
			
			int max = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (!visited[i][j] && board[i][j] == '1') {
						int cnt = dfs(i, j);
						max = Math.max(max, cnt);
					}
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(max);
		}
		
		in.close();
		System.exit(0);
	}
}
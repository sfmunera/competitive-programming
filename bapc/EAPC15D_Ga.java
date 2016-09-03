package bapc;

import java.util.*;

public class EAPC15D_Ga {
	
	static class Position {
		int r, c;
		Position(int r, int c) { this.r = r; this.c = c; }
	}
	
	static boolean inside(int r, int c, int N) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static void solve(int N, char[][] board) {
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		boolean[][] seen = new boolean[N][N];
		Queue<Position> Q = new LinkedList<Position>();
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (board[i][j] == 'w')
					Q.offer(new Position(i, j));
		
		while (!Q.isEmpty()) {
			Position p = Q.poll();
			for (int i = 0; i < dr.length; ++i) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (inside(nr, nc, N) && board[nr][nc] == '-' && !seen[nr][nc]) {
					seen[nr][nc] = true;
					Q.offer(new Position(nr, nc));
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (seen[i][j])
					++ans;
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			char[][] board = new char[N][N];
			
			for (int i = 0; i < N; ++i) {
				board[i] = in.next().toCharArray();
			}
			
			solve(N, board);
		}
		
		in.close();
		System.exit(0);
	}
}

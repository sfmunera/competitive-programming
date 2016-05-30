
import java.util.*;

public class ArcadeManao {
	
	char[][] board;
	int N, M;
	
	boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	boolean bfs(int L, int sr, int sc, int tr, int tc) {
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		boolean[][] seen = new boolean[N][M];
		
		Qr.offer(sr);
		Qc.offer(sc);
		seen[sr][sc] = true;
		
		while (!Qr.isEmpty()) {
			int r = Qr.poll();
			int c = Qc.poll();
			
			if (r == tr && c == tc) return true;
			
			int nc = c - 1;
			if (inside(r, nc) && !seen[r][nc] && board[r][nc] == 'X') {
				seen[r][nc] = true;
				Qr.offer(r);
				Qc.offer(nc);
			}
			nc = c + 1;
			if (inside(r, nc) && !seen[r][nc] && board[r][nc] == 'X') {
				seen[r][nc] = true;
				Qr.offer(r);
				Qc.offer(nc);
			}
			
			for (int l = 1; l <= L; ++l) {
				int nr = r + l;
				if (inside(nr, c) && !seen[nr][c] && board[nr][c] == 'X') {
					seen[nr][c] = true;
					Qr.offer(nr);
					Qc.offer(c);
				}
				nr = r - l;
				if (inside(nr, c) && !seen[nr][c] && board[nr][c] == 'X') {
					seen[nr][c] = true;
					Qr.offer(nr);
					Qc.offer(c);
				}
			}
		}
		return false;
	}
	
    public int shortestLadder(String[] level, int coinRow, int coinColumn) {
        N = level.length;
        M = level[0].length();
        
        board = new char[N][M];
        for (int i = 0; i < N; ++i)
        	board[i] = level[i].toCharArray();
        
        for (int L = 0; L <= 50; ++L)
        	for (int sc = 0; sc < M; ++sc)
        		if (bfs(L, N - 1, sc, coinRow - 1, coinColumn - 1))
        			return L;
        return 0;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ArcadeManao.class, "test.*");
    }

	public void test0() {
		RETester.eq(shortestLadder(new String[] {
			"XXXX....",
			"...X.XXX",
			"XXX..X..",
			"......X.",
			"XXXXXXXX"},
			2, 4), 2);
	}

	public void test1() {
		RETester.eq(shortestLadder(new String[] {
			"XXXX",
			"...X",
			"XXXX"},
			1, 1), 1);
	}

	public void test2() {
		RETester.eq(shortestLadder(new String[] {
			"..X..",
			".X.X.",
			"X...X",
			".X.X.",
			"..X..",
			"XXXXX"},
			1, 3), 4);
	}

	public void test3() {
		RETester.eq(shortestLadder(new String[] {"X"}, 1, 1), 0);
	}

	public void test4() {
		RETester.eq(shortestLadder(new String[] {
			"XXXXXXXXXX",
			"...X......",
			"XXX.......",
			"X.....XXXX",
			"..XXXXX..X",
			".........X",
			".........X",
			"XXXXXXXXXX"},
			1, 1), 2);
	}

// END CUT HERE
}

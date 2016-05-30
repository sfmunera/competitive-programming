
import java.util.*;

public class CoinsGameEasy {
	
	int R, C;
	static final int INF = (int)1e9;
	
	String move(String s, char move) {
		char[][] b = new char[R][C];
		int ind = 0;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				b[i][j] = s.charAt(ind++);

		int[] r = new int[2];
		int[] c = new int[2];
		int k = 0;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j) {
				if (b[i][j] == 'o') {
					r[k] = i;
					c[k] = j;
					++k;
				}
			}
		int[] dr = {-1, 0, 0, 1}; // ULRD
		int[] dc = {0, -1, 1, 0};
		int dir = "ULRD".indexOf(move);
		
		if (move == 'U') {
			if (r[0] > r[1]) {
				int t = r[0];
				r[0] = r[1];
				r[1] = t;
				t = c[0];
				c[0] = c[1];
				c[1] = t;
			}
		}
		if (move == 'D') {
			if (r[0] < r[1]) {
				int t = r[0];
				r[0] = r[1];
				r[1] = t;
				t = c[0];
				c[0] = c[1];
				c[1] = t;
			}
		}
		if (move == 'R') {
			if (c[0] < c[1]) {
				int t = r[0];
				r[0] = r[1];
				r[1] = t;
				t = c[0];
				c[0] = c[1];
				c[1] = t;
			}
		}
		if (move == 'L') {
			if (c[0] > c[1]) {
				int t = r[0];
				r[0] = r[1];
				r[1] = t;
				t = c[0];
				c[0] = c[1];
				c[1] = t;
			}
		}
		
		for (int i = 0; i < 2; ++i) {
			int nr = r[i] + dr[dir];
			int nc = c[i] + dc[dir];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				b[r[i]][c[i]] = '.';
				continue;
			}
			if (b[nr][nc] != '.') {
				continue;
			}
			b[nr][nc] = 'o';
			b[r[i]][c[i]] = '.';
		}
		String ans = "";
		for (int i = 0; i < R; ++i)
			ans += String.valueOf(b[i]);
		return ans;
	}
	
	int bfs(String s) {
		Queue<String> Q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		
		Q.offer(s);
		visited.add(s);
		dist.put(s, 0);
		
		while (!Q.isEmpty()) {
			String b = Q.poll();
			int d = dist.get(b);
			
			if (d > 10) return -1;
			int cnt = 0;
			for (int i = 0; i < R * C; ++i)
				if (b.charAt(i) == 'o')
					++cnt;
			if (cnt == 1)
				return d;
			if (cnt == 0) continue;
			
			String moves = "ULRD";
			for (int i = 0; i < 4; ++i) {
				String next = move(b, moves.charAt(i));
				if (!visited.contains(next)) {
					visited.add(next);
					dist.put(next, d + 1);
					Q.offer(next);
				}
			}
		}
		return -1;
	}
	
    public int minimalSteps(String[] board) {
    	
    	R = board.length;
    	C = board[0].length();
    	
    	String s = "";
    	for (int i = 0; i < R; ++i)
   			s += board[i];
    	
        return bfs(s);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CoinsGameEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimalSteps(new String[] {"oo"}), 1);
	}

	public void test1() {
		RETester.eq(minimalSteps(new String[] {
			".#", 
			".#", 
			".#",
			"o#",
			"o#",
			"##"}),
			4);
	}

	public void test2() {
		RETester.eq(minimalSteps(new String[] {
			"..",
			"..",
			"..",
			"o#",
			"o#",
			"##"}),
			3);
	}

	public void test3() {
		RETester.eq(minimalSteps(new String[] {
			"###",
			".o.",
			"###",
			".o.",
			"###"}),
			-1);
	}

	public void test4() {
		RETester.eq(minimalSteps(new String[] {
			"###",
			".o.",
			"#.#",
			".o.",
			"###"}),
			3);
	}

	public void test5() {
		RETester.eq(minimalSteps(new String[] {
			"###########",
			"........#o#",
			"###########",
			".........o#",
			"###########"}),
			10);
	}

	public void test6() {
		RETester.eq(minimalSteps(new String[] {
			"############",
			".........#o#",
			"############",
			"..........o#",
			"############"}),
			-1);
	}

// END CUT HERE
}

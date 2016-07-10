package leetcode;

import java.util.*;

public class LC200_NumberOfIslands {
	
	class Pair { int r, c; Pair(int r, int c) { this.r = r; this.c = c; } }
	
	boolean inside(Pair p, int rows, int cols) {
		return p.r >= 0 && p.c >= 0 && p.r < rows && p.c < cols;
	}
	
	void bfs(char[][] grid, boolean[][] seen, Pair start) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		Queue<Pair> Q = new LinkedList<Pair>();
		Q.offer(start);
		seen[start.r][start.c] = true;
		
		while (!Q.isEmpty()) {
			Pair x = Q.poll();
			for (int i = 0; i < 4; ++i) {
				Pair next = new Pair(x.r + dr[i], x.c + dc[i]);
				if (inside(next, rows, cols) && !seen[next.r][next.c] && grid[next.r][next.c] == '1') {
					seen[next.r][next.c] = true;
					Q.offer(next);
				}
			}
		}
	}
	
	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if (rows == 0) return 0;
		
		int cols = grid[0].length;
        boolean[][] seen = new boolean[rows][cols];
        
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
        	for (int j = 0; j < cols; ++j) {
        		if (!seen[i][j] && grid[i][j] == '1') {
        			++ans;
        			Pair start = new Pair(i, j);
        			bfs(grid, seen, start);
        		}
        	}
        }
        
        return ans;
    }
}

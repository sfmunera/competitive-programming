package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1277 (10336 - Rank the Languages) */
/* SUBMISSION: 09040463 */
/* SUBMISSION TIME: 2011-07-12 01:03:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10336_RanktheLanguages {
	
	static int H, W;
	static char[][] world;
	static boolean[][] visited;
	
	static boolean valid(int r, int c, char ch) {
		return r >= 0 && c >= 0 && r < H && c < W && world[r][c] == ch && !visited[r][c];
	}
	
	static void dfs(int r, int c, char ch) {
		if (!valid(r, c, ch))
			return;
		
		visited[r][c] = true;
		dfs(r - 1, c, ch);
		dfs(r + 1, c, ch);
		dfs(r, c - 1, ch);
		dfs(r, c + 1, ch);
	}
	
	static class State implements Comparable<State> {
		char state;
		int rank;
		
		public State(char s, int r) {
			this.state = s;
			this.rank = r;
		}

		public int compareTo(State s) {
			if (this.rank != s.rank)
				return s.rank - this.rank;
			return this.state - s.state;
		}
		
		public String toString() {
			return this.state + ": " + this.rank;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			H = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			int[] rank = new int[30];
			
			world = new char[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; ++i)
				world[i] = in.readLine().toCharArray();
			
			for (int i = 0; i < H; ++i)
				for (int j = 0; j < W; ++j)
					if (!visited[i][j]) {
						char c = world[i][j];
						++rank[c - 'a'];
						dfs(i, j, c);
					}
			
			List<State> states = new ArrayList<State>();
			for (char c = 'a'; c <= 'z'; ++c)
				if (rank[c - 'a'] > 0)
					states.add(new State(c, rank[c - 'a']));
			Collections.sort(states);
			
			System.out.println("World #" + t);
			for (State s : states)
				System.out.println(s);
		}
		
		in.close();
		System.exit(0);
	}
}

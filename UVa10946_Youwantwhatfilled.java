package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1887 (10946 - You want what filled?) */
/* SUBMISSION: 09042257 */
/* SUBMISSION TIME: 2011-07-12 15:05:27 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10946_Youwantwhatfilled {
	
	static int R, C, cnt;
	static char[][] field;
	static boolean[][] visited;
	
	static boolean valid(int r, int c, char ch) {
		return r >= 0 && c >= 0 && r < R && c < C && field[r][c] == ch && !visited[r][c];
	}
	
	static void dfs(int r, int c, char ch) {
		if (!valid(r, c, ch))
			return;
		
		visited[r][c] = true;
		++cnt;
		
		dfs(r - 1, c, ch);
		dfs(r + 1, c, ch);
		dfs(r, c - 1, ch);
		dfs(r, c + 1, ch);
	}
	
	static class Hole implements Comparable<Hole> {
		char name;
		int n;
		
		public Hole(char name, int n) {
			this.name = name;
			this.n = n;
		}

		public int compareTo(Hole h) {
			if (this.n != h.n)
				return h.n - this.n;
			return this.name - h.name;
		}
		
		public String toString() {
			return this.name + " " + this.n;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			
			if (R == 0 && C == 0)
				break;
			
			field = new char[R][C];
			visited = new boolean[R][C];
			
			for (int i = 0; i < R; ++i)
				field[i] = in.readLine().toCharArray();
			
			List<Hole> holes = new ArrayList<Hole>();
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					if (field[i][j] != '.' && !visited[i][j]) {
						cnt = 0;
						dfs(i, j, field[i][j]);
						holes.add(new Hole(field[i][j], cnt));
					}
			System.out.println("Problem " + t + ":");
			Collections.sort(holes);
			for (Hole h : holes)
				System.out.println(h);
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
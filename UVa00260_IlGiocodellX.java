package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 196 (260 - Il Gioco dell'X) */
/* SUBMISSION: 09037559 */
/* SUBMISSION TIME: 2011-07-11 03:23:55 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00260_IlGiocodellX {
	
	static char[][] board;
	static int N;
	static boolean[][] visited;
	static char res;
	
	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N && board[i][j] == 'w' && !visited[i][j];
	}
	
	static void dfs(int i, int j) {
		if (!valid(i, j))
			return;
		if (j == N - 1) {
			res = 'W';
			return;
		}
		
		visited[i][j] = true;
		dfs(i - 1, j - 1);
		dfs(i - 1, j);
		dfs(i, j - 1);
		dfs(i, j + 1);
		dfs(i + 1, j);
		dfs(i + 1, j + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			board = new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; ++i)
				board[i] = in.readLine().toCharArray();
			
			res = 'B';
			for (int i = 0; i < N; ++i)
				dfs(i, 0);
			
			System.out.println(t + " " + res);
			++t;
		}
	}
}
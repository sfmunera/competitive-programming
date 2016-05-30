package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 288 (352 - The Seasonal War) */
/* SUBMISSION: 09037691 */
/* SUBMISSION TIME: 2011-07-11 04:35:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00352_TheSeasonalWar {
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N && map[i][j] == '1' && !visited[i][j];
	}
	
	static void dfs(int i, int j) {
		if (!valid(i, j))
			return;
		
		visited[i][j] = true;
		for (int d = 0; d < dx.length; ++d)
			dfs(i + dy[d], j + dx[d]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int t = 1;
		while ((line = in.readLine()) != null) {
			N = Integer.parseInt(line);
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; ++i)
				map[i] = in.readLine().toCharArray();
			
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == '0')
						continue;
					if (!visited[i][j]) {
						++cnt;
						dfs(i, j);
					}
				}
			System.out.println("Image number " + t + " contains " + cnt + " war eagles.");
			++t;
		}
	}
}
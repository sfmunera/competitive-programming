package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 227 (291 - The House Of Santa Claus) */
/* SUBMISSION: 10599548 */
/* SUBMISSION TIME: 2012-09-14 00:42:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00291_TheHouseOfSantaClaus {
	
	static int N = 5;
	static boolean[][] adj = {{false, true, true, false, true}, 
							  {true, false, true, false, true}, 
							  {true, true, false, true, true}, 
							  {false, false, true, false, true}, 
							  {true, true, true, true, false}};
	static boolean[][] visited;
	static Set<String> paths = new TreeSet<String>();
	
	static void backtrack(int s, String path) {
		if (path.length() == 9) {
			paths.add(path);
			return;
		}
		
		for (int i = 0; i < N; ++i)
			if (adj[s][i] && !visited[s][i]) {
				visited[s][i] = visited[i][s] = true;
				backtrack(i, path + (i + 1));
				visited[s][i] = visited[i][s] = false;
			}
	}
	
	public static void main(String[] args) {
		
		visited = new boolean[N][N];
		
		backtrack(0, "1");
		
		//System.out.println(paths.size());
		for (String p : paths)
			System.out.println(p);
		
		System.exit(0);
	}
}

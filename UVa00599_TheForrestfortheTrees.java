package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 540 (599 - The Forrest for the Trees) */
/* SUBMISSION: 09596436 */
/* SUBMISSION TIME: 2011-12-27 19:25:46 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00599_TheForrestfortheTrees {
	
	static boolean[][] adj;
	static boolean[] vertices;
	static boolean[] visited;
	
	static int dfs(int s) {
		visited[s] = true;
		
		int cnt = 0;
		for (int i = 0; i < 26; ++i)
			if (!visited[i] && vertices[i] && adj[s][i])
				cnt += dfs(i);
		return 1 + cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			
			adj = new boolean[26][26];
			vertices = new boolean[26];
			visited = new boolean[26];
			
			while (true) {
				char[] line = in.readLine().toCharArray();
				if (line[0] == '*')
					break;
				
				adj[line[1] - 'A'][line[3] - 'A'] = 
					adj[line[3] - 'A'][line[1] - 'A'] = true;
			}
			
			char[] line = in.readLine().toCharArray();
			
			for (int i = 0; i < line.length; i += 2)
				vertices[line[i] - 'A'] = true;
			
			int trees = 0;
			int acorns = 0;
			
			for (int i = 0; i < 26; ++i) {
				if (vertices[i]) {
					boolean ok = false;
					for (int j = 0; j < 26; ++j)
						
						ok |= adj[i][j];
					if (!ok)
						++acorns;
				}
			}
			
			for (int i = 0; i < 26; ++i)
				if (!visited[i]) {
					int cnt = dfs(i);
					if (cnt > 1)
						++trees;
				}
			
			System.out.println("There are " + trees + " tree(s) and " + acorns + " acorn(s).");
		}
		
		in.close();
		System.exit(0);
	}
}

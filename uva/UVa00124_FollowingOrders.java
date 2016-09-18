package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 60 (124 - Following Orders) */
/* SUBMISSION: 09367326 */
/* SUBMISSION TIME: 2011-10-13 17:28:05 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00124_FollowingOrders {
	static int n;
	static boolean[][] adj;
	static char[] vertices;
	static colors[] color;
	static int time;
	static int[] ti;
	static int[] tf;
	static String sort;
	static boolean[] used;
	static Set<String> res;
	enum colors {WHITE, GRAY, BLACK};
	
	static void dfs(int s) {
		
		ti[s] = ++time; // Discover time
		color[s] = colors.GRAY; // Discover vertex
		
		for (int i = 0; i < 26; ++i)
			if (adj[s][i] && color[i] == colors.WHITE) // If neighbor and not discovered
				dfs(i);
			
		color[s] = colors.BLACK; // Vertex is finished
		tf[s] = ++time; // Finish time
		
		sort = (char)(s + 'a') + sort;
	}
	
	static void topsort(char[] b) {
		time = 0;
		ti = new int[26];
		tf = new int[26];
		color = new colors[26];
		sort = "";
		
		Arrays.fill(color, colors.WHITE);
		
		for (int i = 0; i < n; ++i)
			if (color[b[i] - 'a'] == colors.WHITE)
				dfs(b[i] - 'a');
				
		res.add(sort);
	}
	
	static void backtrack(char[] b, int k) {
		
		if (k == n) {
			topsort(b);
			return;
		}
		for (int i = 0; i < n; ++i)
			if (!used[i]) {
				int v = vertices[k] - 'a';
				int w = vertices[i] - 'a';
				used[i] = true;
				b[k] = vertices[i];
				backtrack(b, k + 1);
				used[i] = false;
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		
		boolean first = true;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			n = stk.countTokens();
			vertices = new char[n];
			adj = new boolean[26][26];
			
			for (int i = 0; i < n; ++i)
				vertices[i] = stk.nextToken().charAt(0);
			
			stk = new StringTokenizer(in.readLine());
			int m = stk.countTokens() / 2;
			for (int i = 0; i < m; ++i) {
				char from = stk.nextToken().charAt(0);
				char to = stk.nextToken().charAt(0);
				
				adj[from - 'a'][to - 'a'] = true;
			}
			if (first)
				first = false;
			else
				System.out.println();
			
			used = new boolean[n];
			char[] b = new char[n];
			res = new TreeSet<String>();
			backtrack(b, 0);
			
			for (String s : res)
				System.out.println(s);
		}
		
		in.close();
		System.exit(0);
	}
}
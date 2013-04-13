package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 813 (872 - Ordering) */
/* SUBMISSION: 09367524 */
/* SUBMISSION TIME: 2011-10-13 18:22:19 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00872_Ordering {
	static int n;
	static boolean[][] adj;
	static char[] vertices;
	static colors[] color;
	static int time;
	static int[] ti;
	static int[] tf;
	static String sort;
	static boolean[] used;
	static boolean cycle;
	static Set<String> res;
	enum colors {WHITE, GRAY, BLACK};
	
	static void dfs(int s) {
		
		if (cycle)
			return;
		
		ti[s] = ++time; // Discover time
		color[s] = colors.GRAY; // Discover vertex
		
		for (int i = 0; i < 26; ++i)
			if (adj[s][i] && color[i] == colors.WHITE) // If neighbor and not discovered
				dfs(i);
			else if (adj[s][i] && color[i] == colors.GRAY) {
				//System.out.println("(" + (char)(s + 'A') + ", " + (char)(i + 'A') + ")");
				cycle = true;
				return;
			}
			
		color[s] = colors.BLACK; // Vertex is finished
		tf[s] = ++time; // Finish time
		
		if (!sort.isEmpty())
			sort = " " + sort;
		sort = (char)(s + 'A') + sort;
	}
	
	static void topsort(char[] b) {
		time = 0;
		ti = new int[26];
		tf = new int[26];
		color = new colors[26];
		sort = "";
		
		Arrays.fill(color, colors.WHITE);
		
		for (int i = 0; i < n; ++i)
			if (color[b[i] - 'A'] == colors.WHITE)
				dfs(b[i] - 'A');
				
		res.add(sort);
	}
	
	static void backtrack(char[] b, int k) {
		
		if (cycle)
			return;
		
		if (k == n) {
			topsort(b);
			return;
		}
		for (int i = 0; i < n; ++i)
			if (!used[i]) {
				used[i] = true;
				b[k] = vertices[i];
				backtrack(b, k + 1);
				used[i] = false;
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		
		boolean first = true;
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			in.readLine();
			stk = new StringTokenizer(in.readLine());
			n = stk.countTokens();
			vertices = new char[n];
			adj = new boolean[26][26];
			
			for (int i = 0; i < n; ++i)
				vertices[i] = stk.nextToken().charAt(0);
			
			stk = new StringTokenizer(in.readLine());
			int m = stk.countTokens();
			for (int i = 0; i < m; ++i) {
				String token = stk.nextToken();
				char from = token.charAt(0);
				char to = token.charAt(token.length() - 1);
				
				adj[from - 'A'][to - 'A'] = true;
			}
			if (first)
				first = false;
			else
				System.out.println();
			
			used = new boolean[n];
			char[] b = new char[n];
			res = new TreeSet<String>();
			
			cycle = false;
			
			backtrack(b, 0);
			
			if (!cycle)
				for (String s : res)
					System.out.println(s);
			else
				System.out.println("NO");
		}
		
		in.close();
		System.exit(0);
	}
}

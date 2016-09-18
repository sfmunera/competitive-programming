package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 136 (200 - Rare Order) */
/* SUBMISSION: 09367427 */
/* SUBMISSION TIME: 2011-10-13 17:57:58 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00200_RareOrder {
	
	static boolean[][] adj;
	static boolean[] vertices;
	static boolean[] visited;
	static String sort;
	
	static void dfs(int s) {
		
		visited[s] = true;
		for (int i = 0; i < 26; ++i)
			if (adj[s][i] && !visited[i])
				dfs(i);
		
		sort = (char)(s + 'A') + sort;
	}
	
	static void topsort() {
		visited = new boolean[26];
		sort = "";
		
		for (int i = 0; i < 26; ++i)
			if (vertices[i] && !visited[i])
				dfs(i);
		System.out.println(sort);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> dict = new ArrayList<String>();
		vertices = new boolean[26];
		adj = new boolean[26][26];
		int maxlen = 0;
		
		while (true) {
			String line = in.readLine();
			if (line.equals("#"))
				break;
			
			dict.add(line);
			maxlen = Math.max(maxlen, line.length());
		}
		
		for (int i = 0; i < maxlen; ++i)
			for (int j = 0; j < dict.size(); ++j) {
				String s = dict.get(j);
				if (i >= s.length())
					continue;
				vertices[s.charAt(i) - 'A'] = true;
				if (j > 0) {
					String prev = dict.get(j - 1);
					if (prev.length() > i) {
						if (i == 0 && s.charAt(i) != prev.charAt(i))
							adj[prev.charAt(i) - 'A'][s.charAt(i) - 'A'] = true;
						else if (s.charAt(i) != prev.charAt(i)) {
							boolean ok = true;
							for (int k = 0; k < i && ok; ++k)
								if (s.charAt(k) != prev.charAt(k))
									ok = false;
							if (ok)
								adj[prev.charAt(i) - 'A'][s.charAt(i) - 'A'] = true;
						}
					}
				}
			}
		
		topsort();
		
		in.close();
		System.exit(0);
	}
}

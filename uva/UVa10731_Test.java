package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1672 (10731 - Test) */
/* SUBMISSION: 09422182 */
/* SUBMISSION TIME: 2011-10-30 00:27:47 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa10731_Test {
	
	static int N;
	static boolean[][] adj;
	static boolean[] used;
	static boolean[] visited;
	static List<Character> sort;
	
	static void dfs(char s) {
		visited[s - 'A'] = true;
		
		for (int i = 0; i < 26; ++i)
			if (adj[s - 'A'][i] && !visited[i]) {
				visited[i] = true;
				dfs((char)(i + 'A'));
			}
		sort.add(0, s);
	}
	
	static void topsort() {
		visited = new boolean[26];
		sort = new ArrayList<Character>();
		
		for (int i = 0; i < 26; ++i)
			if (used[i] && !visited[i])
				dfs((char)(i + 'A'));
	}
	
	static List<Character> dfs2(char s, List<Character> res) {
		visited[s - 'A'] = true;
		
		res.add(s);
		for (int i = 0; i < 26; ++i)
			if (adj[i][s - 'A'] && !visited[i]) {
				visited[i] = true;
				res = dfs2((char)(i + 'A'), res);
			}
		return res;
	}
	
	static void scc() {
		topsort();
		List<String> sets = new ArrayList<String>();
		visited = new boolean[26];
		
		for (char c : sort) {
			if (!visited[c - 'A']) {
				List<Character> res = dfs2(c, new ArrayList<Character>());
				Collections.sort(res);
				String set = "";
				boolean first = true;
				for (char ch : res) {
					if (first)
						first = false;
					else
						set += " ";
					set += ch;
				}
				sets.add(set);
			}
		}
		Collections.sort(sets);
		for (String s : sets)
			System.out.println(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			adj = new boolean[26][26];
			used = new boolean[26];
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				char from = parts[5].charAt(0);
				for (int j = 0; j < 5; ++j) {
					char to = parts[j].charAt(0);
					
					if (to != from) {
						adj[from - 'A'][to - 'A'] = true;
						used[from - 'A'] = used[to - 'A'] = true;
					}
				}
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			scc();
		}
		
		in.close();
		System.exit(0);
	}
}
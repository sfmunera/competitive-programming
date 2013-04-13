package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 104 (168 - Theseus and the Minotaur) */
/* SUBMISSION: 11451246 */
/* SUBMISSION TIME: 2013-03-16 15:21:04 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00168_TheseusandtheMinotaur {
	
	static int k;
	static ArrayList<Integer>[] adj;
	static boolean[] seen;
	static StringBuilder ans;
	
	static void dfs(int s, int step, int prev) {
		if (step % k == 0)
			seen[s] = true;
		
		boolean found = false;
		for (int i : adj[s])
			if (i != prev && !seen[i]) {
				dfs(i, step + 1, s);
				found = true;
				break;
			}
		if (!found)
			ans.append("/" + (char)(s + 'A') + "\n");
		else if (step % k == 0)
			ans.insert(0, (char)(s + 'A') + " ");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while (!(line = in.readLine()).equals("#")) {
			String[] parts = line.split("[ ]+");
			char minotaur = parts[1].charAt(0);
			char theseus = parts[2].charAt(0);
			k = Integer.parseInt(parts[3]);
			
			adj = new ArrayList[26];
			seen = new boolean[26];
			
			for (int i = 0; i < 26; ++i)
				adj[i] = new ArrayList<Integer>();
			
			parts = parts[0].split("[;]+");
			for (int i = 0; i < parts.length; ++i) {
				char from = parts[i].charAt(0);
				for (int j = 2; j < parts[i].length(); ++j) {
					char to = parts[i].charAt(j);
					if (to >= 'A' && to <= 'Z')
						adj[from - 'A'].add(to - 'A');
				}
			}
			
			ans = new StringBuilder();
			dfs(minotaur - 'A', 1, theseus - 'A');
			System.out.print(ans);
		}
		
		in.close();
		System.exit(0);
	}
}

package codeforces;

import java.io.*;
import java.util.*;

public class Coins {
	
	static boolean[][] g;
	static boolean[] seen;
	static ArrayList<Integer> sort;
	
	static void dfs(int u) {
		seen[u] = true;
		for (int v = 0; v < 3; ++v)
			if (!seen[v] && g[u][v])
				dfs(v);
		sort.add(u);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		g = new boolean[3][3];
		
		String line;
		while ((line = in.readLine()) != null) {
			char from = line.charAt(0);
			char op = line.charAt(1);
			char to = line.charAt(2);
			
			if (op == '>')
				g[from - 'A'][to - 'A'] = true;
			else
				g[to - 'A'][from - 'A'] = true;
		}
		
		String ans = "";
		int cnt = 0;
		for (int i = 0; i < 3; ++i) {
			seen = new boolean[3];
			sort = new ArrayList<Integer>();
			dfs(i);
			if (sort.size() == 3) {
				++cnt;
				for (int x : sort)
					ans += (char)(x + 'A');
			}
		}
		if (cnt > 1)
			System.out.println("Impossible");
		else
			System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
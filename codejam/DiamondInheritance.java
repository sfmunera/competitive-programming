package codejam;

import java.util.*;
import java.io.*;

public class DiamondInheritance {
	
	static boolean[][] adj;
	static boolean[] visited;
	static int N;
	static boolean isDiamond;
	
	static void dfs(int s) {
		if (visited[s]) {
			isDiamond = true;
			return;
		}
		
		visited[s] = true;
		for (int i = 0; i < N; ++i)
			if (adj[s][i])
				dfs(i);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("A-large.in"));
		System.setOut(new PrintStream("out.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(in.readLine());
			adj = new boolean[N][N];
			visited = new boolean[N];
			isDiamond = false;
			
			for (int i = 0; i < N; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int M = Integer.parseInt(parts[0]);
				for (int j = 1; j <= M; ++j) {
					int to = Integer.parseInt(parts[j]) - 1;
					adj[i][to] = true;
				}
			}
			
			for (int i = 0; i < N; ++i) {
				visited = new boolean[N];
				dfs(i);
			}
			
			System.out.println("Case #" + t + ": " + (isDiamond ? "Yes" : "No"));
		}
		
		in.close();
		System.exit(0);
	}
}

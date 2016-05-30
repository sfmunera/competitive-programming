package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1242 (10301 - Rings and Glue) */
/* SUBMISSION: 09299524 */
/* SUBMISSION TIME: 2011-09-26 00:01:16 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10301_RingsandGlue {
	
	static int N;
	static boolean[] visited;
	static boolean[][] adj;
	
	static int dfs(int s) {
		
		if (visited[s])
			return 0;
		
		visited[s] = true;
		
		int cnt = 0;
		for (int i = 0; i < N; ++i)
			if (adj[s][i])
				cnt += dfs(i);
		
		return 1 + cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == -1)
				break;
			
			double[] x = new double[N];
			double[] y = new double[N];
			double[] r = new double[N];
			
			for (int i = 0; i < N; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				x[i] = Double.parseDouble(stk.nextToken());
				y[i] = Double.parseDouble(stk.nextToken());
				r[i] = Double.parseDouble(stk.nextToken());
			}
			
			adj = new boolean[N][N];
			for (int i = 0; i < N; ++i)
				for (int j = i + 1; j < N; ++j) {
					double dx = x[i] - x[j];
					double dy = y[i] - y[j];
					double d = Math.sqrt(dx * dx + dy * dy);
					
					if (Double.compare(d, r[i] + r[j]) < 0 && 
							Double.compare(d, Math.abs(r[i] - r[j])) > 0)
						adj[i][j] = adj[j][i] = true;
				}
			
			int max = 0;
			for (int i = 0; i < N; ++i) {
				visited = new boolean[N];
				max = Math.max(max, dfs(i));
			}
			System.out.println("The largest component contains " + max + " ring" + (max != 1 ? "s" : "") + ".");
					
		}
		
		in.close();
		System.exit(0);
	}
}

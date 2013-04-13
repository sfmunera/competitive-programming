package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 216 (280 - Vertex) */
/* SUBMISSION: 09142217 */
/* SUBMISSION TIME: 2011-08-12 16:01:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00280_Vertex {
	
	static int n;
	static boolean[][] adjacency;
	static boolean[] reachable;
	static enum color {WHITE, GRAY, BLACK};
	static color[] status;
	
	static void dfs(int s) {
		status[s] = color.GRAY;
		
		for (int i = 0; i < n; ++i)
			if (adjacency[s][i]) {
				reachable[i] = true;
				if (status[i] == color.WHITE)
					dfs(i);
			}
		status[s] = color.BLACK;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while ((n = Integer.parseInt(in.readLine())) != 0) {
			adjacency = new boolean[n][n];
			
			while (true) {
				String line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				int i = Integer.parseInt(stk.nextToken());
				if (i == 0)
					break;
				int j;
				while ((j = Integer.parseInt(stk.nextToken())) != 0)
					adjacency[i - 1][j - 1] = true;
			}
			
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			int m = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < m; ++i) {
				reachable = new boolean[n];
				status = new color[n];
				
				for (int j = 0; j < n; ++j)
					status[j] = color.WHITE;
				
				int s = Integer.parseInt(stk.nextToken());
				
				dfs(s - 1);
				
				int cnt = 0;
				StringBuilder res = new StringBuilder();
				for (int k = 0; k < n; ++k)
					if (!reachable[k])
						++cnt;
				res.append(cnt);
				for (int k = 0; k < n; ++k)
					if (!reachable[k])
						res.append(" " + (k + 1));
				System.out.println(res);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
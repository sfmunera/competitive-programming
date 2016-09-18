package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3497 (1056 - Degrees of Separation) */
/* SUBMISSION: 11045027 */
/* SUBMISSION TIME: 2012-12-18 14:44:03 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01056_DegreesofSeparation {
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int t = 1;
		while (true) {
			int P = in.nextInt();
			int R = in.nextInt();
			if (P == 0 && R == 0) break;
			
			int[][] adj = new int[P][P];
			for (int i = 0; i < P; ++i) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}
			
			System.out.print("Network " + t + ": ");

			int ind = 0;
			Map<String, Integer> index = new HashMap<String, Integer>();
			for (int i = 0; i < R; ++i) {
				String u = in.next();
				String v = in.next();
				if (!index.containsKey(u))
					index.put(u, ind++);
				if (!index.containsKey(v))
					index.put(v, ind++);
				int ind1 = index.get(u);
				int ind2 = index.get(v);
				
				adj[ind1][ind2] = adj[ind2][ind1] = 1;
			}
			
			for (int k = 0; k < P; ++k)
				for (int i = 0; i < P; ++i)
					for (int j = 0; j < P; ++j)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			int ans = 0;
			for (int i = 0; i < P; ++i)
				for (int j = 0; j < P; ++j)
					ans = Math.max(ans, adj[i][j]);
			
			System.out.println(ans >= INF ? "DISCONNECTED" : ans);
			
			++t;
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}

package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1448 (10507 - Waking up brain) */
/* SUBMISSION: 10880192 */
/* SUBMISSION TIME: 2012-11-13 14:18:30 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10507_Wakingupbrain {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		String line;
		while ((line = in.readLine()) != null) {
			if (first)
				first = false;
			else
				line = in.readLine();
			int N = Integer.parseInt(line);
			int M = Integer.parseInt(in.readLine());
			char[] wake = in.readLine().toCharArray();
			
			boolean[][] adj = new boolean[26][26];
			boolean[] waken = new boolean[26];
			for (int i = 0; i < 3; ++i)
				waken[wake[i] - 'A'] = true;
			
			for (int i = 0; i < M; ++i) {
				char[] pair = in.readLine().toCharArray();
				adj[pair[0] - 'A'][pair[1] - 'A'] = adj[pair[1] - 'A'][pair[0] - 'A'] = true;
			}
			int time = -1;
			for (int t = 1; t <= 100; ++t) {
				boolean[] wakenTmp = waken.clone();
				int cnt = 0;
				for (int u = 0; u < 26; ++u) {
					if (!wakenTmp[u]) {
						int neighs = 0;
						for (int v = 0; v < 26; ++v)
							if (adj[u][v] && wakenTmp[v])
								++neighs;
						if (neighs >= 3) {
							++cnt;
							waken[u] = true;
						}
					}
				}
				if (cnt == 0) {
					time = t - 1;
					break;
				}
			}
			int cnt = 0;
			for (int i = 0; i < 26; ++i)
				if (waken[i])
					++cnt;
			if (cnt != N)
				time = -1;
			if (time == -1)
				System.out.println("THIS BRAIN NEVER WAKES UP");
			else
				System.out.println("WAKE UP IN, " + time + ", YEARS");
		}
		
		in.close();
		System.exit(0);
	}
}

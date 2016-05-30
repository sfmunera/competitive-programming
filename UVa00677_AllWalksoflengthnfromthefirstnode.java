package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 618 (677 - All Walks of length "n" from the first node) */
/* SUBMISSION: 11342391 */
/* SUBMISSION TIME: 2013-02-25 20:36:21 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00677_AllWalksoflengthnfromthefirstnode {
	
	static int N;
	static boolean[][] adj;
	static boolean[] visited;
	static boolean found;
	
	static void go(String path, int s, int k) {
		if (k == 0) {
			found = true;
			path += (s + 1);
			System.out.println("(" + path + ")");
			return;
		}
		path += (s + 1) + ",";
		
		for (int i = 0; i < N; ++i)
			if (!visited[i] && adj[s][i]) {
				visited[i] = true;
				go(path, i, k - 1);
				visited[i] = false;
			}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		boolean first = true;
		String line;
		while ((line = in.readLine()) != null) {
			if (first) first = false; else System.out.println();
			if (line.equals("-9999")) line = in.readLine();
			
			stk = new StringTokenizer(line);
			N = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			adj = new boolean[N][N];
			visited = new boolean[N];
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					int x = Integer.parseInt(stk.nextToken());
					if (x == 1)
						adj[i][j] = true;
				}
			}
			visited[0] = true;
			found = false;
			go("", 0, k);
			
			if (!found)
				System.out.println("no walk of length " + k);
		}
		
		in.close();
		System.exit(0);
	}
}

package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 370 (429 - Word Transformation) */
/* SUBMISSION: 09049139 */
/* SUBMISSION TIME: 2011-07-14 19:11:51 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00429_WordTransformation {
	
	static int N;
	static boolean[][] adj;
	
	static int[] bfs(int s) {
		int[] distance = new int[N];
		int[] parent = new int[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(s);
		visited[s] = true;
		distance[s] = 0;
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			for (int w = 0; w < N; ++w)
				if (adj[v][w] && !visited[w]) {
					distance[w] = distance[v] + 1;
					parent[w] = v;
					visited[w] = true;
					Q.offer(w);
				}
		}
		
		return distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			Map<String, Integer> words = new HashMap<String, Integer>();
			N = 0;
			
			while (true) {
				String w = in.readLine();
				if (w.equals("*"))
					break;
				words.put(w, N++);
			}
			adj = new boolean[N][N];
			
			for (String v : words.keySet())
				for (String w : words.keySet()) {
					if (v.equals(w) || v.length() != w.length())
						continue;
					int n = v.length();
					int cnt = 0;
					for (int i = 0; i < n; ++i)
						if (v.charAt(i) != w.charAt(i))
							++cnt;
					if (cnt == 1)
						adj[words.get(v)][words.get(w)] = adj[words.get(w)][words.get(v)] = true;
				}
			if (first)
				first = false;
			else
				System.out.println();
			String line;
			while ((line = in.readLine()) != null) {
				if (line.isEmpty())
					break;
				String[] pair = line.split("[ ]");
				int[] distance = bfs(words.get(pair[0]));
				
				int cost = distance[words.get(pair[1])];
				System.out.println(pair[0] + " " + pair[1] + " " + cost);
			}
		}
		
		in.close();
		System.exit(0);
	}
}

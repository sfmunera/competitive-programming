package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2508 (11513 - 9 Puzzle) */
/* SUBMISSION: 09239904 */
/* SUBMISSION TIME: 2011-09-08 19:49:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11513_9Puzzle {
	static final int target = 123456789;
	
	static int move(int s, int i, boolean isVertical) {
		int[][] mat = new int[3][3];
		
		for (int j = 2; j >= 0; --j)
			for (int k = 2; k >= 0; --k) {
				mat[j][k] = s % 10;
				s /= 10;
			}
		
		if (isVertical) {
			int t = mat[2][i];
			mat[2][i] = mat[1][i];
			mat[1][i] = mat[0][i];
			mat[0][i] = t;
		} else {
			int t = mat[i][0];
			mat[i][0] = mat[i][1];
			mat[i][1] = mat[i][2];
			mat[i][2] = t;
		}
		
		s = 0;
		for (int j = 0; j < 3; ++j)
			for (int k = 0; k < 3; ++k)
				s = s * 10 + mat[j][k];
		
		return s;
	}
	
	static Map<Integer, String> bfs(int s) {
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, String> path = new HashMap<Integer, String>();
		Queue<Integer> Q = new LinkedList<Integer>();
		String[] moves = {"H1", "H2", "H3", "V1", "V2", "V3"};
		
		visited.add(s);
		path.put(s, "");
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int v = Q.poll();
			
			int[] w = new int[6];
			for (int i = 0; i < 3; ++i)
				w[i] = move(v, i, false);
			
			for (int i = 0; i < 3; ++i)
				w[i + 3] = move(v, i, true);
			
			for (int i = 5; i >= 0; --i) {
				if (!visited.contains(w[i])) {
					visited.add(w[i]);
					path.put(w[i], moves[i] + path.get(v));
					Q.offer(w[i]);
				}
			}
		}
		
		return path;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, String> path = bfs(target);
		
		while (true) {
			String line = in.readLine();
			if (line.equals("0"))
				break;
			
			int s = 0;
			for (int i = 0; i < 3; ++i) {
				if (i > 0)
					line = in.readLine();
				StringTokenizer stk = new StringTokenizer(line);
				for (int j = 0; j < 3; ++j)
					s = s * 10 + Integer.parseInt(stk.nextToken());
			}
			
			if (!path.containsKey(s))
				System.out.println("Not solvable");
			else {
				String p = path.get(s);
				int n = p.length();
				System.out.println(n / 2 + " " + p);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
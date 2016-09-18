package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1363 (10422 - Knights in FEN) */
/* SUBMISSION: 10346941 */
/* SUBMISSION TIME: 2012-07-17 15:51:22 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10422_KnightsinFEN {
	
	static String solved = "111110111100 110000100000";
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static boolean inside(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 5;
	}
	
	static void swap(char[] b, int i, int j) {
		char t = b[i];
		b[i] = b[j];
		b[j] = t;
	}
	
	static int bfs(String s) {
		Set<String> visited = new HashSet<String>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		Queue<String> Q = new LinkedList<String>();
		
		visited.add(s);
		dist.put(s, 0);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			String x = Q.poll();
			int d = dist.get(x);
			if (d > 10)
				return -1;
			if (x.equals(solved))
				return d;
			
			int r = 0;
			int c = 0;
			for (int i = 0; i < x.length(); ++i)
				if (x.charAt(i) == ' ') {
					r = i / 5;
					c = i % 5;
					break;
				}
			
			char[] board = x.toCharArray();
			for (int k = 0; k < dr.length; ++k) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (inside(nr, nc)) {
					swap(board, 5 * r + c, 5 * nr + nc);
					String next = String.valueOf(board);
					swap(board, 5 * r + c, 5 * nr + nc);
					if (!visited.contains(next)) {
						visited.add(next);
						dist.put(next, d + 1);
						Q.offer(next);
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String board = "";
			for (int i = 0; i < 5; ++i)
				board += in.readLine();
			int dist = bfs(board);
			if (dist >= 0)
				System.out.println("Solvable in " + dist + " move(s).");
			else
				System.out.println("Unsolvable in less than 11 move(s).");
		}
		
		in.close();
		System.exit(0);
	}
}

package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 428 (487 - Boggle Blitz) */
/* SUBMISSION: 09247015 */
/* SUBMISSION TIME: 2011-09-10 22:17:40 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00487_BoggleBlitz {
	
	static int N;
	static char[][] table;
	static boolean[][] visited;
	static Set<String> words;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static void backtrack(int r, int c, String word) {
		
		if (word.length() > 2)
			words.add(word);
		if (visited[r][c])
			return;
		
		visited[r][c] = true;
		
		for (int d = 0; d < 8; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!inside(nr, nc))
				continue;
			if (word.isEmpty() || table[nr][nc] > word.charAt(word.length() - 1))
				backtrack(nr, nc, word + table[nr][nc]);
		}
		
		visited[r][c] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			N = Integer.parseInt(in.readLine());
			table = new char[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; ++i)
				table[i] = in.readLine().toCharArray();
			
			words = new TreeSet<String>(new Comparator<String>() {
				public int compare(String w1, String w2) {
					if (w1.length() < w2.length())
						return -1;
					if (w1.length() > w2.length())
						return 1;
					return w1.compareTo(w2);
				}
				
			});
			
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					backtrack(i, j, "" + table[i][j]);
			
			if (first)
				first = false;
			else
				System.out.println();
			
			for (String w : words)
				System.out.println(w);
		}
		
		in.close();
		System.exit(0);
	}
}

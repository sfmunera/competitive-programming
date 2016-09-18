package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1043 (10102 - The path in the colored field) */
/* SUBMISSION: 09054841 */
/* SUBMISSION TIME: 2011-07-16 19:55:43 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10102_Thepathinthecoloredfield {
	
	static int M;
	static char[][] field;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < M && c < M;
	}
	
	static int bfs() {
		int[][] distance = new int[M][M];
		boolean[][] visited = new boolean[M][M];
		Queue<Integer> Qr = new LinkedList<Integer>();
		Queue<Integer> Qc = new LinkedList<Integer>();
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; ++i)
			Arrays.fill(distance[i], -1);
		
		int ones = 0;
		for (int i = 0; i < M; ++i)
			for (int j = 0; j < M; ++j) {
				if (field[i][j] == '3') {
					visited[i][j] = true;
					distance[i][j] = 0;
					Qr.offer(i);
					Qc.offer(j);
				}
				if (field[i][j] == '1')
					++ones;
			}
		
		while (!Qr.isEmpty()) {
			int nr = Qr.poll();
			int nc = Qc.poll();
			
			for (int d = 0; d < 4; ++d) {
				int sr = nr + dr[d];
				int sc = nc + dc[d];
				if (inside(sr, sc) && !visited[sr][sc]) {
					visited[sr][sc] = true;
					distance[sr][sc] = distance[nr][nc] + 1;
					
					if (field[sr][sc] == '1')
						--ones;
					if (ones == 0)
						return distance[sr][sc];
					
					Qr.offer(sr);
					Qc.offer(sc);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			M = Integer.parseInt(line);
			field = new char[M][M];
			
			for (int i = 0; i < M; ++i)
				field[i] = in.readLine().toCharArray();
			
			System.out.println(bfs());
		}
		
		in.close();
		System.exit(0);
	}
}
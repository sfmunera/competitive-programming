package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 717 (776 - Monkeys in a Regular Forest) */
/* SUBMISSION: 09121302 */
/* SUBMISSION TIME: 2011-08-06 18:21:24 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00776_MonkeysinaRegularForest {
	
	static char[][] map;
	static int[][] res;
	static boolean[][] visited;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int R, C;
	
	static boolean inside(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static void dfs(int r, int c, char ch, int mark) {
		if (!inside(r, c))
			return;
		if (visited[r][c])
			return;
		if (map[r][c] != ch)
			return;
		
		res[r][c] = mark;
		visited[r][c] = true;
		
		for (int d = 0; d < 8; ++d)
			dfs(r + dr[d], c + dc[d], ch, mark);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while (true) {
			List<String> lines = new ArrayList<String>();
			while ((line = in.readLine()) != null) {
				if (!line.isEmpty() && line.equals("%"))
					break;
				lines.add(line);
			}

			if (lines.isEmpty())
				break;
			
			R = lines.size();
			C = lines.get(0).split("[ ]").length;
			
			map = new char[R][C];
			visited = new boolean[R][C];
			res = new int[R][C];
			
			for (int i = 0; i < R; ++i) {
				line = lines.get(i);
				String[] parts = line.split("[ ]");

				for (int j = 0; j < C; ++j)
					map[i][j] = parts[j].charAt(0);
			}
			int k = 1;
			for (int r = 0; r < R; ++r)
				for (int c = 0; c < C; ++c)
					if (!visited[r][c]) {
						dfs(r, c, map[r][c], k);
						++k;
					}
			int[] spaces = new int[C];
			for (int i = 0; i < C; ++i) {
				int max = 0;
				for (int j = 0; j < R; ++j)
					max = Math.max(max, res[j][i]);
				int cnt = 0;
				while (max > 0) {
					++cnt;
					max /= 10;
				}
				spaces[i] = cnt;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					if (j > 0)
						sb.append(" ");
					sb.append(String.format("%" + spaces[j] + "d", res[i][j]));
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.out.println("%");

		}
		
		in.close();
		System.exit(0);
	}
}

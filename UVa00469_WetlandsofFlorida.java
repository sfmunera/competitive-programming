package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 410 (469 - Wetlands of Florida) */
/* SUBMISSION: 09040220 */
/* SUBMISSION TIME: 2011-07-11 21:58:47 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00469_WetlandsofFlorida {
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dc = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dr = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int R;
	static int C;
	static int res;
	
	static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C && map[r][c] == 'W' && !visited[r][c];
	}
	
	static void dfs(int r, int c) {
		if (!valid(r, c))
			return;
		
		visited[r][c] = true;
		++res;
		
		for (int d = 0; d < dc.length; ++d)
			dfs(r + dr[d], c + dc[d]);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		int T = Integer.parseInt(in.nextLine());
		in.nextLine();
			
		for (int t = 1; t <= T; ++t) {
			List<String> lines = new ArrayList<String>();
				
			R = 0;
			C = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.isEmpty())
					break;
	
				if (line.charAt(0) == 'L' || line.charAt(0) == 'W') {
					++R;
					C = line.length();
				}
				lines.add(line);
			}
			
			map = new char[R][C];
			for (int i = 0; i < R; ++i)
				map[i] = lines.get(i).toCharArray();
			//System.out.println(Arrays.deepToString(map));
			if (t > 1)
				System.out.println();
			for (int i = R; i < lines.size(); ++i) {
				visited = new boolean[R][C];
				StringTokenizer stk = new StringTokenizer(lines.get(i));
				int r = Integer.parseInt(stk.nextToken()) - 1;
				int c = Integer.parseInt(stk.nextToken()) - 1;
					
				res = 0;
				dfs(r, c);
				System.out.println(res);
			}
		}
		System.exit(0);
	}
}

package eafit;

import java.io.*;

public class Cijevi {
	
	static char[][] mat;
	static int R, C;
	static boolean[][] visited;
	
	static boolean inside(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
	
	static boolean dfs(int sr, int sc) {
		if (!inside(sr, sc))
			return false;
		if (visited[sr][sc])
			return false;
		if (mat[sr][sc] == '.')
			return false;
		
		if (mat[sr][sc] == 'Z')
			return true;
		visited[sr][sc] = true;
		
		boolean ok = false;
		switch (mat[sr][sc]) {
		case '|':
			ok |= dfs(sr - 1, sc);
			ok |= dfs(sr + 1, sc);
			break;
		case '-':
			ok |= dfs(sr, sc - 1);
			ok |= dfs(sr, sc + 1);
			break;
		case '+':
			ok |= dfs(sr - 1, sc);
			ok |= dfs(sr + 1, sc);
			ok |= dfs(sr, sc - 1);
			ok |= dfs(sr, sc + 1);
			break;
		case '1':
			ok |= dfs(sr + 1, sc);
			ok |= dfs(sr, sc + 1);
			break;
		case '2':
			ok |= dfs(sr - 1, sc);
			ok |= dfs(sr, sc + 1);
			break;
		case '3':
			ok |= dfs(sr - 1, sc);
			ok |= dfs(sr, sc - 1);
			break;
		case '4':
			ok |= dfs(sr + 1, sc);
			ok |= dfs(sr, sc - 1);
			break;
		}
		
		return ok;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		R = Integer.parseInt(parts[0]);
		C = Integer.parseInt(parts[1]);
		
		mat = new char[R][C];
		char[] pieces = {'|', '-', '1', '2', '3', '4', '+'};
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		
		for (int i = 0; i < R; ++i)
			mat[i] = in.readLine().toCharArray();
		
		int sr = 0;
		int sc = 0;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				if (mat[i][j] == 'M') {
					sr = i;
					sc = j;
				}
		
		boolean ok = false;
		for (int i = 0; i < R && !ok; ++i)
			for (int j = 0; j < C && !ok; ++j) {
				int cnt = 0;
				if (mat[i][j] != '.')
					continue;
				for (int d = 0; d < 4; ++d) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (inside(nr, nc) && mat[nr][nc] != '.')
						++cnt;
				}
				if (cnt >= 2) {
					for (int k = 0; k < pieces.length; ++k) {
						mat[i][j] = pieces[k];
						visited = new boolean[R][C];
						ok = dfs(sr, sc);
						mat[i][j] = '.';
						
						if (ok) {
							System.out.println((i + 1) + " " + (j + 1) + " " + pieces[k]);
							break;
						}
					}
				}
			}
		
		in.close();
		System.exit(0);
	}
}

package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 598 (657 - The die is cast) */
/* SUBMISSION: 10326712 */
/* SUBMISSION TIME: 2012-07-12 19:36:25 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00657_Thedieiscast {
	
	static int W, H, cnt;
	static char[][] image;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] di = {-1, 0, 0, 1};
	static int[] dj = {0, -1, 1, 0};
	
	static boolean inside(int i, int j) {
		return i >= 0 && i < H && j >= 0 && j < W;
	}
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int d = 0; d < 4; ++d) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (inside(ni, nj) && !visited[ni][nj] && image[ni][nj] != '.') {
				if (image[ni][nj] == 'X' && !visited2[ni][nj]) {
					if (image[i][j] != 'X')
						++cnt;
					dfs2(ni, nj);
				}
				dfs(ni, nj);
			}
		}
	}
	
	static void dfs2(int i, int j) {
		visited2[i][j] = true;
		
		for (int d = 0; d < 4; ++d) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (inside(ni, nj) && !visited2[ni][nj] && image[ni][nj] == 'X')
				dfs2(ni, nj);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			W = Integer.parseInt(parts[0]);
			H = Integer.parseInt(parts[1]);
			
			if (W == 0 && H == 0) break;
			
			image = new char[H][W];
			visited = new boolean[H][W];
			visited2 = new boolean[H][W];
			for (int i = 0; i < H; ++i)
				image[i] = in.readLine().toCharArray();
			
			List<Integer> dies = new ArrayList<Integer>();
			for (int i = 0; i < H; ++i)
				for (int j = 0; j < W; ++j) {
					if (image[i][j] != '.' && !visited[i][j]) {
						cnt = 0;
						if (image[i][j] == 'X') {
							++cnt;
							dfs2(i, j);
						}
						dfs(i, j);
						dies.add(cnt);
					}
				}
			Collections.sort(dies);
			System.out.println("Throw " + t);
			for (int i = 0; i < dies.size(); ++i) {
				if (i > 0)
					System.out.print(" ");
				System.out.print(dies.get(i));
			}
			System.out.println();
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}

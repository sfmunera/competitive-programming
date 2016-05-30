package codeforces;

import java.util.*;

public class LittlePigsAndWolves {
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	static boolean inside(int r, int c, int rows, int cols) {
		return r >= 0 && c >= 0 && r < rows && c < cols;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] field = new char[n][m];
		for (int i = 0; i < n; ++i) {
			field[i] = in.next().toCharArray();
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (field[i][j] == 'W') {
					boolean hasPigs = false;
					for (int d = 0; d < 4; ++d) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						if (inside(ni, nj, n, m) && field[ni][nj] == 'P') {
							hasPigs = true;
							break;
						}
					}
					if (hasPigs)
						++ans;
				}
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}

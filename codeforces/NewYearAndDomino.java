package codeforces;

import java.util.*;

public class NewYearAndDomino {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int cols = in.nextInt();
		
		char[][] grid = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			grid[i] = in.next().toCharArray();
		}
		
		long[][] waysHor = new long[rows][cols];
		long[][] waysVer = new long[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j == 0) {
					waysHor[i][j] = 0;
					waysVer[i][j] = 0;
				} else {
					if (i > 0 && grid[i][j] == '.' && grid[i - 1][j] == '.') {
						waysVer[i][j]++;
					}
					if (j > 0 && grid[i][j] == '.' && grid[i][j - 1] == '.') {
						waysHor[i][j]++;
					}
					if (i > 0) {
						waysHor[i][j] += waysHor[i - 1][j];
						waysVer[i][j] += waysVer[i - 1][j];
					}
					if (j > 0) {
						waysHor[i][j] += waysHor[i][j - 1];
						waysVer[i][j] += waysVer[i][j - 1];
					}
					if (i > 0 && j > 0) {
						waysHor[i][j] -= waysHor[i - 1][j - 1];
						waysVer[i][j] -= waysVer[i - 1][j - 1];
					}
				}
			}
		}
		
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int r1 = in.nextInt() - 1;
			int c1 = in.nextInt() - 1;
			int r2 = in.nextInt() - 1;
			int c2 = in.nextInt() - 1;
			
			long ans = waysHor[r2][c2] + waysVer[r2][c2];
			if (r1 > 0) {
				ans -= waysHor[r1 - 1][c2];
				ans -= waysVer[r1][c2];
			}
			if (c1 > 0) {
				ans -= waysHor[r2][c1];
				ans -= waysVer[r2][c1 - 1];
			}
			if (r1 > 0 && c1 > 0) {
				ans += waysHor[r1 - 1][c1];
				ans += waysVer[r1][c1 - 1];
			}
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}

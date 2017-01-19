package codeforces;

import java.util.*;

public class StronglyConnectedCity {
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int cols = in.nextInt();
		String horizontalDirections = in.next();
		String verticalDirections = in.next();
		int N = rows * cols;
		
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			adj[i][i] = 1;
		}
		int[] dr = {-1, 0, 1, 0}; // even: vertical, odd: horizontal
		int[] dc = {0, -1, 0, 1};
		for (int i = 0; i < N; i++) {
			int row = i / cols, col = i % cols;
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 0 && nc >= 0 && nr < rows && nc < cols) {
					int j = nr * cols + nc;
					if (d % 2 == 0) { // vertical neighbor
						char dir = verticalDirections.charAt(col);
						if (dir == '^') {
							if (nr > row) {
								adj[j][i] = 1;
							} else {
								adj[i][j] = 1;
							}
						} else {
							if (nr > row) {
								adj[i][j] = 1;
							} else {
								adj[j][i] = 1;
							}
						}
					} else { // horizontal neighbor
						char dir = horizontalDirections.charAt(row);
						if (dir == '<') {
							if (nc > col) {
								adj[j][i] = 1;
							} else {
								adj[i][j] = 1;
							}
						} else {
							if (nc > col) {
								adj[i][j] = 1;
							} else {
								adj[j][i] = 1;
							}
						}
					}
				}
			}
		}
		
		for (int k = 0; k < N; k++) for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
			adj[i][j] |= adj[i][k] & adj[k][j];
		}
		
		boolean connected = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adj[i][j] == 0) {
					connected = false;
				}
			}
		}
		
		System.out.println(connected ? "YES" : "NO");
		
		in.close();
		System.exit(0);
	}
}

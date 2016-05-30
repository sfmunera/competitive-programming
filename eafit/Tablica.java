package eafit;

import java.io.*;
import java.util.*;

public class Tablica {

	static void rotateCol(int[][] mat, int[][] pos, int id, int k) {
		int N = mat[0].length;
		
		int[] tmp = new int[N];
		for (int i = 0; i < N; ++i) {
			tmp[(i + k) % N] = mat[i][id];
			int r = mat[i][id] / N;
			int c = mat[i][id] % N;
			pos[r][c] = ((i + k) % N) * N + id;
		}
		for (int i = 0; i < N; ++i)
			mat[i][id] = tmp[i];
	}
	
	static void rotateRow(int[][] mat, int[][] pos, int id, int k) {
		int N = mat.length;
		
		int[] tmp = new int[N];
		for (int i = 0; i < N; ++i) {
			tmp[(i + k) % N] = mat[id][i];
			int r = mat[id][i] / N;
			int c = mat[id][i] % N;
			pos[r][c] = id * N + (i + k) % N;
		}
		for (int i = 0; i < N; ++i)
			mat[id][i] = tmp[i];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		int N = Integer.parseInt(parts[0]);
		int K = Integer.parseInt(parts[1]);
		
		int[][] mat = new int[N][N];
		int[][] pos = new int[N][N];
		
		int k = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j) {
				mat[i][j] = k++;
				pos[i][j] = mat[i][j];
			}
		for (int i = 0; i < K; ++i) {
			parts = in.readLine().split("[ ]+");
			int X = Integer.parseInt(parts[0]) - 1;
			int R = Integer.parseInt(parts[1]) - 1;
			int C = Integer.parseInt(parts[2]) - 1;
			
			int tmp = pos[X / N][X % N];
			int nR = tmp / N;
			int nC = tmp % N;
			
			int dR = Math.abs(nR - R);
			int dC = Math.abs(nC - C);
			
			if (R < nR)
				dR = N - dR;
			if (C < nC)
				dC = N - dC;
			
			int ans = dR + dC;
			rotateRow(mat, pos, nR, dC);
			rotateCol(mat, pos, C, dR);
			
			System.out.println(ans);
		}
		
		
		in.close();
		System.exit(0);
	}
}

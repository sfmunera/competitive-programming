package codeforces;

import java.io.*;
import java.util.*;

public class TheLeastRoundWay {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][][] dp = new int[N][N][2];
		int[][][] cnt = new int[N][N][2];
		int[][] mat = new int[N][N];
		char[][] p = new char[N][N];
		
		for (int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j)
				mat[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j) {
				while (mat[i][j] % 2 == 0) {
					++cnt[i][j][0];
					mat[i][j] /= 2;
				}
				while (mat[i][j] % 5 == 0) {
					++cnt[i][j][1];
					mat[i][j] /= 5;
				}
				for (int k = 0; k < 2; ++k)
					dp[i][j][k] = Integer.MAX_VALUE;
			}
		
		dp[0][0][0] = cnt[0][0][0];
		dp[0][0][1] = cnt[0][0][1];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				for (int k = 0; k < 2; ++k) {
					if (i + 1 < N) {
						if (dp[i + 1][j][k] > dp[i][j][k] + cnt[i + 1][j][k]) {
							dp[i + 1][j][k] = dp[i][j][k] + cnt[i + 1][j][k];
							p[i + 1][j] = 'D';
						}
					}
					if (j + 1 < N) {
						if (dp[i][j + 1][k] > dp[i][j][k] + cnt[i][j + 1][k]) {
							dp[i][j + 1][k] = dp[i][j][k] + cnt[i][j + 1][k];
							p[i][j + 1] = 'D';
						}
					}
				}
		String path = "";
		
		for (int i = 0; i < N; ++i)
			System.out.println(Arrays.toString(dp[i]));
		
		int i = N - 1;
		int j = N - 1;
		while (true) {
			if (i == 0 && j == 0) break;
			path = p[i][j] + path;
			if (p[i][j] == 'D') --i;
			else --j;
		}
		
		System.out.println(dp[N - 1][N - 1]);
		System.out.println(path);
		
		in.close();
		System.exit(0);
	}
}
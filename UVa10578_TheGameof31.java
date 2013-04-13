package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1519 (10578 - The Game of 31) */
/* SUBMISSION: 10970810 */
/* SUBMISSION TIME: 2012-12-02 05:36:18 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10578_TheGameof31 {

	static boolean[][][][][][][] dp;
	static boolean[][][][][][][] seen;
	
	static boolean canWin(int sum, int c1, int c2, int c3, int c4, int c5, int c6) {
		if (sum > 31)
			return true;
		
		if (seen[sum][c1][c2][c3][c4][c5][c6])
			return dp[sum][c1][c2][c3][c4][c5][c6];

		seen[sum][c1][c2][c3][c4][c5][c6] = true;
		
		int[] c = {c1, c2, c3, c4, c5, c6};
		for (int i = 0; i < 6; ++i) {
			if (c[i] > 0) {
				--c[i];
				if (!canWin(sum + i + 1, c[0], c[1], c[2], c[3], c[4], c[5]))
					return dp[sum][c1][c2][c3][c4][c5][c6] = true;
				++c[i];
			}
		}
		return dp[sum][c1][c2][c3][c4][c5][c6] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int[] c = new int[6];
			int sum = 0;
			
			dp = new boolean[40][5][5][5][5][5][5];
			seen = new boolean[40][5][5][5][5][5][5];
			
			Arrays.fill(c, 4);
			for (int i = 0; i < line.length(); ++i) {
				int val = line.charAt(i) - '0';
				--c[val - 1];
				sum += val;
			}
			char[] players = {'A', 'B'};
			int turn = line.length() % 2; // 0: A, 1: B
			boolean can = canWin(sum, c[0], c[1], c[2], c[3], c[4], c[5]);
			
			System.out.println(line + " " + (can ? players[turn] : players[1 - turn]));
			
		}
		
		in.close();
		System.exit(0);
	}
}

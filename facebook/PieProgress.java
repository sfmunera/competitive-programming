package facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class PieProgress {
	
	static final long INF = Long.MAX_VALUE / 3;
	
	static int days, pies;
	static int[][] accumCost;
	static Long[][] dp;
	
	static long solve(int day, int piesAccum) {
		if (piesAccum < 0 || piesAccum > days) {
			return INF;
		}
		if (day == days) {
			return piesAccum == 0 ? 0 : INF;
		}
		if (dp[day][piesAccum] != null) {
			return dp[day][piesAccum];
		}
		
		long ans = INF;
		for (int p = 0; p <= pies; p++) {
			long cost = (p == 0 ? 0 : accumCost[day][p - 1]) + p * p;
			ans = Math.min(ans, cost + solve(day + 1, piesAccum + p - 1));
		}
		return dp[day][piesAccum] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("pie_progress.txt")));
		System.setOut(new PrintStream(new File("pie_progress.out")));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int testNumber = 1; testNumber <= T; testNumber++) {
			days = in.nextInt();
			pies = in.nextInt();
			accumCost = new int[days][pies];
			for (int i = 0; i < days; i++) {
				for (int j = 0; j < pies; j++) {
					accumCost[i][j] = in.nextInt();
				}
				Arrays.sort(accumCost[i]);
				for (int j = 1; j < pies; j++) {
					accumCost[i][j] += accumCost[i][j - 1];
				}
			}
			dp = new Long[days + 5][days + 5];
			long ans = solve(0, 0);
			System.out.println("Case #" + testNumber + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}

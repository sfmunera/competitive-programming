package facebook;

import java.io.*;
import java.util.*;

public class WinningAtSports {
	
	static final int MOD = 1000000007;
	static int[][] dp1, dp2;
	
	static int goStressFree(int first, int second) {
		if (first == 1 && second == 0)
			return 1;
		
		if (dp1[first][second] != -1)
			return dp1[first][second];
				
		int ans = 0;
		if (second > 0) {
			ans = goStressFree(first, second - 1) % MOD;
		}
		if (first - 1 > second) {
			ans = (ans + goStressFree(first - 1, second)) % MOD;
		}
		
		return dp1[first][second] = ans;
	}
	
	static int goStressful(int first, int second) {
		if (first == 0 && second == 0)
			return 1;
		
		if (dp2[first][second] != -1)
			return dp2[first][second];
		
		int ans = 0;
		if (second - 1 >= first) {
			ans = goStressful(first, second - 1) % MOD;
		}
		if (first > 0) {
			ans = (ans + goStressful(first - 1, second)) % MOD;
		}
		
		return dp2[first][second] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("B.in")));
		System.setOut(new PrintStream(new File("B.out")));
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			String input = in.next();
			String[] parts = input.split("-");
			int first = Integer.parseInt(parts[0]);
			int second = Integer.parseInt(parts[1]);
			
			dp1 = new int[first + 1][second + 1];
			dp2 = new int[first + 1][second + 1];
			
			for (int i = 0; i <= first; ++i)
				for (int j = 0; j <= second; ++j) {
					dp1[i][j] = -1;
					dp2[i][j] = -1;
				}
			
			int stressFree = goStressFree(first, second);
			int stressful = goStressful(first, second);
			
			System.out.println("Case #" + t + ": " + stressFree + " " + stressful);
		}
		
		in.close();
	}
}

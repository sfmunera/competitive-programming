package facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class LazyLoading {
	
	static final int MIN_WEIGHT = 50;
	
	static int getMinItems(int top) {
		return MIN_WEIGHT / top + (MIN_WEIGHT % top != 0 ? 1 : 0);
	}
	
	static int solveGreedy(int[] weights) {
		int itemsLeft = weights.length;
		
		int ans = 0;
		for (int i = weights.length - 1; i >= 0; i--) {
			int min = getMinItems(weights[i]);
			if (itemsLeft >= min) {
				ans++;
				itemsLeft -= min;
			} else {
				break;
			}
		}
		
		return ans;
	}
	
	static Integer[][] dp;
	static int solveDp(int[] weights) {
		int N = weights.length;
		dp = new Integer[N + 5][N + 5];
		return dp(weights.length - 1, weights.length, weights);
	}
	
	static int dp(int index, int itemsLeft, int[] weights) {
		if (index < 0) {
			return 0;
		}
		if (itemsLeft <= 0) {
			return 0;
		}
		
		if (dp[index][itemsLeft] != null) {
			return dp[index][itemsLeft];
		}
		
		int min = getMinItems(weights[index]);
		int ans = dp(index - 1, itemsLeft, weights); // no choosing
		if (itemsLeft >= min) {
			ans = Math.max(ans, 1 + dp(index - 1, itemsLeft - min, weights)); // choosing
		}

		return dp[index][itemsLeft] = ans;
	}
	
	static boolean testEqualApproaches() {
		final int RUNS = 100;
		
		boolean alwaysEqual = true;
		for (int run = 0; run < RUNS; run++) {
			int N = random(1, 100);
			int[] weights = new int[N];
			for (int i = 0; i < N; i++) {
				weights[i] = random(1, 100);
			}
			Arrays.sort(weights);
			
			int ansGreedy = solveGreedy(weights);
			int ansDp = solveDp(weights);
			alwaysEqual &= ansGreedy == ansDp;
		}
		
		return alwaysEqual;
	}
	
	static int random(int left, int right) {
		int range = right - left + 1;     
		return (int)(Math.random() * range) + left;
	}

	public static void main(String[] args) throws IOException {
		//System.out.println((testEqualApproaches() ? "" : "Not ") + "Equal approaches");
		
		System.setIn(new FileInputStream(new File("lazy_loading.txt")));
		System.setOut(new PrintStream(new File("lazy_loading.out")));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int testNumber = 1; testNumber <= T; testNumber++) {
			int N = in.nextInt();
			int[] weights = new int[N];
			
			for (int i = 0; i < N; i++) {
				weights[i] = in.nextInt();
			}
			Arrays.sort(weights);
			
			System.out.println("Case #" + testNumber + ": " + solveGreedy(weights));
		}
		
		in.close();
		System.exit(0);
	}
}

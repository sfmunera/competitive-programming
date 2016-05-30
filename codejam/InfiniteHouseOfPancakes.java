package codejam;

import java.util.*;
import java.io.*;

public class InfiniteHouseOfPancakes {
	
	static final String FILENAME = "B-large-practice";
	
	static void solve(int test, int[] pancakes) {
		System.out.print("Case #" + test + ": ");
		
		int upperBound = 0;
		for (int x : pancakes) {
			upperBound = Math.max(upperBound, x);
		}
		int ans = upperBound;
		
		for (int i = 1; i <= upperBound; ++i) {
			int cnt = 0;
			for (int j = 0; j < pancakes.length; ++j) {
				if (pancakes[j] > i) {
					cnt += (pancakes[j] - i - 1) / i + 1;
				}
			}
			ans = Math.min(ans, cnt + i);
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(FILENAME + ".in"));
		System.setOut(new PrintStream(FILENAME + ".out"));
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int test = 1; test <= T; ++test) {
			int D = in.nextInt();
			int[] pancakes = new int[D];
			
			for (int i = 0; i < D; ++i) {
				pancakes[i] = in.nextInt();
			}
			solve(test, pancakes);
		}
		in.close();
	}
}

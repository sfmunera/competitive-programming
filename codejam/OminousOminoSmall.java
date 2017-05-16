package codejam;

import java.io.*;
import java.util.*;

public class OminousOmino {
	static final String FILENAME = "D-small-practice";
	
	static void solve(int test, int X, int R, int C) {
		System.out.print("Case #" + test + ": ");

		String[] ans = {"RICHARD", "GABRIEL"};
		int choice = 0;
		
		if (X <= 4 && (R * C) % X == 0 && R * C >= X * (X - 1)) {
			++choice;
		}
		
		System.out.println(ans[choice]);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(FILENAME + ".in"));
		System.setOut(new PrintStream(FILENAME + ".out"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int numTests = Integer.parseInt(in.readLine());
		
		for (int test = 1; test <= numTests; ++test) {
			// Read input
			stk = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			// Solve it
			solve(test, X, R, C);
		}
	}
}
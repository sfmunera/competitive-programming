package codejam;

import java.io.*;
import java.util.*;

public class StandingOvation {
	static final String FILENAME = "A-large";
	
	static void solve(int test, int Smax, String audience) {
		System.out.print("Case #" + test + ": ");
		
		int ans = 0;
		int sum = 0;
		for (int i = 0; i <= Smax; ++i) {
			int p = audience.charAt(i) - '0';
			if (sum < i) {
				int diff = i - sum;
				ans += diff;
				sum += diff;
			}
			sum += p;
		}
		
		System.out.println(ans);
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
			int Smax = Integer.parseInt(stk.nextToken());
			String audience = stk.nextToken();
			
			// Solve it
			solve(test, Smax, audience);
		}
	}
}

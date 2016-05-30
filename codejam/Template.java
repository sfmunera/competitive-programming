package codejam;

import java.io.*;
import java.util.*;

public class Template {
	static final String FILENAME = "As";
	
	static void solve(int test) {
		System.out.print("Case #" + test + ": ");
		
		
		System.out.println();
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
			
			
			// Solve it
			solve(test);
		}
	}
}

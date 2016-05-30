package codejam;

import java.util.*;
import java.io.*;

public class GCJTemplate {
	static final String FILENAME = "A";
	static Scanner in;
	static StringBuilder sb;

	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static void solve(int t) {
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream(FILENAME + ".in"));
	    //System.setOut(new PrintStream(FILENAME + ".out"));
		in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			sb = new StringBuilder();
			solve(t);
		}
		
		in.close();
		System.exit(0);
	}
}
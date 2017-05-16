package codejam;

import java.util.*;
import java.io.*;

public class CloseMatch {
	static final String FILENAME = "Bs";
	static Scanner in;
	static StringBuilder sb;

	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static boolean can(String C, String J, int c, int j) {
		int len = C.length();
		String C2 = String.format("%0" + len + "d", c);
		String J2 = String.format("%0" + len + "d", j);
		
		for (int i = 0; i < len; ++i) {
			if (C.charAt(i) != '?') {
				if (C.charAt(i) != C2.charAt(i)) return false;
			}
			if (J.charAt(i) != '?') {
				if (J.charAt(i) != J2.charAt(i)) return false;
			}
		}
		
		return true;
	}
	
	static void solve(int t) {
		String C = in.next();
		String J = in.next();
		
		int len = C.length();
		int pow10 = 1;
		for (int i = 0; i < len; ++i) {
			pow10 *= 10;
		}
		
		int min = Integer.MAX_VALUE;
		int bestC = 0;
		int bestJ = 0;
		for (int c = 0; c < pow10; ++c) {
			for (int j = 0; j < pow10; ++j) {
				if (can(C, J, c, j) && Math.abs(c - j) < min) {
					min = Math.abs(c - j);
					bestC = c;
					bestJ = j;
				}
			}
		}
		sb.append(String.format("%0" + len + "d", bestC));
		sb.append(" ");
		sb.append(String.format("%0" + len + "d", bestJ));
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(FILENAME + ".in"));
	    System.setOut(new PrintStream(FILENAME + ".out"));
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
package codejam;

import java.util.*;
import java.io.*;

public class TheLastWord {
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static void solve(String S, int t) {
		StringBuilder sb = new StringBuilder();
		sb.append(S.charAt(0));
		
		for (int i = 1; i < S.length(); ++i) {
			if (S.charAt(i) < sb.charAt(0)) {
				sb.append(S.charAt(i));
			} else {
				sb.insert(0, S.charAt(i));
			}
		}
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("A-large-practice.in"));
	    System.setOut(new PrintStream("A-large-practice.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			String S = in.next();
			solve(S, t);
		}
		
		in.close();
		System.exit(0);
	}
}
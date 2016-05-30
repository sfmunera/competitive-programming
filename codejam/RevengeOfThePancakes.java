package codejam;

import java.util.*;
import java.io.*;

public class RevengeOfThePancakes {
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	// f(i, s): # steps so that all S[0..i] are c ('+' or '-')
	static int f(int i, char c, String S) {
		if (i == 0) return S.charAt(i) == c ? 0 : 1;
		
		if (S.charAt(i) == c) {
			return f(i - 1, c, S);
		} else {
			return 1 + f(i - 1, c == '+' ? '-' : '+', S);
		}
	}
	
	static void solve(String S, int t) {
		print(new StringBuilder().append(f(S.length() - 1, '+', S)), t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("B-large.in"));
	    System.setOut(new PrintStream("B-large.out"));
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
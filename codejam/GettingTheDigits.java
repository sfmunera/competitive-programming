package codejam;

import java.util.*;
import java.io.*;

public class GettingTheDigits {
	static final String FILENAME = "Al";
	static Scanner in;
	static StringBuilder sb;

	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static String[] digits = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
	static int[] order = {0, 6, 7, 2, 4, 5, 3, 8, 1, 9};
	
	static boolean hasDigit(int[] cnt, String digit) {
		boolean found = true;
		int[] cnt2 = new int[26];
		for (int i = 0; i < digit.length(); ++i) {
			++cnt2[digit.charAt(i) - 'A'];
		}
		
		boolean[] seen = new boolean[26];
		for (int i = 0; i < digit.length(); ++i) {
			if (!seen[digit.charAt(i) - 'A'] && cnt[digit.charAt(i) - 'A'] - cnt2[digit.charAt(i) - 'A'] < 0) {
				found = false;
				break;
			}
			seen[digit.charAt(i) - 'A'] = true;
		}
		
		if (found) {
			seen = new boolean[26];
			for (int i = 0; i < digit.length(); ++i) {
				if (!seen[digit.charAt(i) - 'A'])
					cnt[digit.charAt(i) - 'A'] -= cnt2[digit.charAt(i) - 'A'];
				seen[digit.charAt(i) - 'A'] = true;
			}
		}
		
		return found;
	}
	
	static void solve(int t) {
		String S = in.next();
		
		int[] cnt = new int[26];
		for (int i = 0; i < S.length(); ++i) {
			++cnt[S.charAt(i) - 'A'];
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < 10; ++i) {
			while (hasDigit(cnt, digits[order[i]])) {
				ans.add(order[i]);
			}
		}
		Collections.sort(ans);
		
		for (int x : ans) {
			sb.append(x);
		}		
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
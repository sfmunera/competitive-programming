package codejam;

import java.util.*;
import java.io.*;

public class GarbledEmail {
	
	static final int INF = (int)(1e9);
	static String S;
	static HashSet<String> dict;
	static int[] dp;
	static int[] dp2;
	static boolean[] seen;
	static boolean[] seen2;
	
	static int cost(int i, String s) {
		if (i >= s.length()) {
			if (!dict.contains(s)) return INF;
			return 0;
		}
		if (seen2[i]) return dp2[i];
		seen2[i] = true;
		
		char[] c = s.toCharArray();
		int ans = cost(i + 1, s);
		char t = c[i];
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			if (t == ch) continue;
			c[i] = ch;
			String ns = String.valueOf(c);
			ans = Math.min(ans, 1 + cost(i + 5, ns));
		}
		return dp2[i] = ans;
	}
	
	static int go(int idx) {
		if (idx >= S.length()) return 0;
		if (seen[idx]) return dp[idx];
		seen[idx] = true;
		
		String substr = S.substring(idx);
		seen2 = new boolean[substr.length() + 1];
		dp2 = new int[substr.length() + 1];
		int ans = cost(0, substr);
		for (int i = idx + 1; i <= S.length(); ++i) {
			String word = S.substring(idx, i);
			seen2 = new boolean[word.length() + 1];
			dp2 = new int[word.length() + 1];
			int cost = cost(0, word);
			ans = Math.min(ans, cost + go(i));
		}
		
		return dp[idx] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("garbled_email_dictionary.txt"));
		dict = new HashSet<String>();
		String str;
		while ((str = in.readLine()) != null) {
			dict.add(str);
		}
		
		System.setIn(new FileInputStream("C-small-practice.in"));
		System.setOut(new PrintStream("outC.txt"));
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			S = in.readLine();
			dp = new int[S.length() + 1];
			seen = new boolean[S.length() + 1];
			System.out.println("Case #" + t + ": " + go(0));
		}
		
		in.close();
		System.exit(0);
	}
}

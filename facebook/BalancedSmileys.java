package facebook;

import java.io.*;

public class BalancedSmileys {

	static String str;
	static boolean[][] seen;
	static boolean[][] dp;
	
	static boolean go(int i, int cnt) {
		if (i == str.length())
			return cnt == 0;
		if (cnt < 0)
			return false;
		
		if (seen[i][cnt])
			return dp[i][cnt];
		
		boolean ans = false;
		if (str.charAt(i) == '(')
			ans = go(i + 1, cnt + 1);
		else if (str.charAt(i) == ')')
			ans = go(i + 1, cnt - 1);
		else if (str.charAt(i) == ':') {
			ans = go(i + 1, cnt);
			if (i + 1 < str.length() && (str.charAt(i + 1) == '(' || str.charAt(i + 1) == ')'))
				ans |= go(i + 2, cnt);
		} else
			ans = go(i + 1, cnt);
		
		seen[i][cnt] = true;
		return dp[i][cnt] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("in.txt"));
		System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			str = in.readLine();
			
			seen = new boolean[200][200];
			dp = new boolean[200][200];
			
			boolean ans = go(0, 0);
			System.out.println("Case #" + t + ": " + (ans ? "YES" : "NO"));
		}
		
		in.close();
		System.exit(0);
	}
}

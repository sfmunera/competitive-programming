import java.util.*;

public class AlienRibonucleicAcidMaxContiguous {
	
	static boolean inside(int length, int position) {
		return position >= 0 && position < length;
	}
	
	static boolean matches(char first, char second) {
        String pair = "" + first + second;
        return "CFC".contains(pair) || "SBS".contains(pair);
    }
	
	// Time: O(N^3), Space: O(N^2)
	static int solve(String rnaa, int start, int end, Integer[][] dp) {
		if (start > end) return 0;
		
		if (dp[start][end] != null) return dp[start][end];
		int ans = 0;
		for (int i = start; i + 1 <= end; i++) {
			int left = i;
			int right = i + 1;
			while (inside(rnaa.length(), left) && inside(rnaa.length(), right) && matches(rnaa.charAt(left), rnaa.charAt(right))) {
				ans = (right - left + 1) / 2;
				ans = Math.max(ans, solve(rnaa, start, left - 1, dp));
				ans = Math.max(ans, solve(rnaa, right + 1, end, dp));
				left--;
				right++;
			}
		}
		return dp[start][end] = ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String rnaa = in.next();
			int N = rnaa.length();
			System.out.println(solve(rnaa, 0, N - 1, new Integer[N + 1][N + 1]));
		}
		in.close();
		System.exit(0);
	}
}

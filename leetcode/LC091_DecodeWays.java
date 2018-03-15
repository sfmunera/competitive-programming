import java.util.*;

public class LC091_DecodeWays {
	
	public static int numDecodingsMemo(String s) {
		if (s.isEmpty()) {
			return 0;
		} else {
			Integer[] memo = new Integer[s.length() + 1];
			return numDecodingsMemo(0, s, memo);
		}
    }
	
	private static int numDecodingsMemo(int index, String s, Integer[] memo) {
		if (index == s.length()) {
			return 1;
		}
		if (memo[index] != null) {
			return memo[index];
		}
		int ways = 0;
		if (index < s.length()) {
			int num = (s.charAt(index) - '0');
			if (num >= 1 && num <= 9) {
				 ways += numDecodingsMemo(index + 1, s, memo); // match one digit [1-9]
			}
		}
		if (index < s.length() - 1) {
			int num = 10 * (s.charAt(index) - '0') + (s.charAt(index + 1) - '0');
			if (num >= 10 && num <= 26) {
				ways += numDecodingsMemo(index + 2, s, memo); // match two digits [10-26]
			}
		}
		return memo[index] = ways;
	}
	
	private static int numDecodings(String s) {
		if (s.isEmpty()) return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			int num = (s.charAt(i - 1) - '0');
			if (num >= 1 && num <= 9) {
				dp[i] = dp[i - 1]; 
			}
			if (i > 1) {
				num = 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0');
				if (num >= 10 && num <= 26) {
					dp[i] += dp[i - 2];
				}
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String code = in.next();
		System.out.println(numDecodings(code));
		
		in.close();
		System.exit(0);
	}
}

package interview;

import java.util.*;

public class ModerateUnconcatenate {
	
	static HashSet<String> dictionary;
	static String s;
	static Integer[] dp;
	
	static int go(int index) {
		if (index == s.length())
			return 0;
		
		if (dp[index] != null)
			return dp[index];
		
		int ans = Integer.MAX_VALUE;
		for (int i = index + 1; i <= s.length(); ++i) {
			String substring = s.substring(index, i);
			int cost = 0;
			if (!dictionary.contains(substring))
				cost = substring.length();
			ans = Math.min(ans, cost + go(i));
		}
		
		return dp[index] = ans;
	}
	
	public static void main(String[] args) {
		s = "jesslookedjustliketimherbrother";
		
		dictionary = new HashSet<String>();
		dictionary.add("looked");
		dictionary.add("just");
		dictionary.add("like");
		dictionary.add("her");
		dictionary.add("brother");
		
		dp = new Integer[s.length() + 1];
		System.out.println(go(0));
	}
}

package leetcode;

import java.util.*;

public class LC291_WordPatternII {
    public boolean wordPatternMatch(String pattern, String input) {
        if (pattern == null || input == null) {
			throw new NullPointerException();
		}

		boolean matches = canMatchPattern(0, 0, new HashMap<Character, String>(), pattern, input);
		
		return matches;
    }
    
    private static boolean canMatchPattern(
			int patternIndex, // index of character to be matched
			int inputIndex, // index where the rest of the input to be matched begins
			Map<Character, String> matching, // current matching
			final String pattern, // original pattern
			final String input) { // original input
		
		if (patternIndex == pattern.length() && inputIndex == input.length()) {
			return true;
		}
		if (patternIndex == pattern.length() || inputIndex == input.length()) {
			return false;
		}
		
		char currentSymbol = pattern.charAt(patternIndex);
		if (matching.containsKey(currentSymbol)) {
			String matchedSymbol = matching.get(currentSymbol);
			if (!input.startsWith(matchedSymbol, inputIndex)) {
				return false;
			}
			return canMatchPattern(patternIndex + 1, inputIndex + matchedSymbol.length(), matching, pattern, input);
		} else {
			boolean canMatch = false;
			for (int end = inputIndex + 1; end <= input.length(); end++) {
				String matchedSymbol = input.substring(inputIndex, end);
				if (matching.values().contains(matchedSymbol)) {
					continue;
				} else {
					matching.put(currentSymbol, matchedSymbol);
					canMatch |= canMatchPattern(patternIndex + 1, end, matching, pattern, input);
					matching.remove(currentSymbol);
				}
			}
			return canMatch;
		}
	}
}

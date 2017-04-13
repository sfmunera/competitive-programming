package leetcode;

import java.util.*;

public class LC003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                left = Math.max(left, position.get(ch) + 1);
            }
            position.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

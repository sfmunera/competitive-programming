package leetcode;

import java.util.*;

public class LC387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int ans = -1;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            count.put(c, count.get(c) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.get(c) == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}

package leetcode;

import java.util.*;

public class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        return wordBreak(s, words, new HashMap<String, Boolean>());
    }
    
    public boolean wordBreak(String s, Set<String> words, Map<String, Boolean> seen) {
        if (words.contains(s)) return true;
        if (seen.containsKey(s)) {
            return seen.get(s);
        }
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (!words.contains(sub)) {
                continue;
            }
            String rest = s.substring(i, s.length());
            if (wordBreak(rest, words, seen)) {
                seen.put(s, true);
                return true;
            }
        }
        seen.put(s, false);
        return false;
    }
}

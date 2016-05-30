package topcoder;

import java.util.*;

public class StringGame {
	
	boolean less(String s1, String s2, String alphabet) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; ++i)
			if (c1[i] != c2[i])
				return alphabet.indexOf(c1[i]) < alphabet.indexOf(c2[i]);
		return false;
	}
	
    public int[] getWinningStrings(String[] S) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < S.length; ++i) {
        	boolean[] taken = new boolean[26];
        	String alphabet = "";
        	char[] c = S[i].toCharArray();
        	Arrays.sort(c);
        	for (int j = 0; j < c.length; ++j)
        		if (!taken[c[j] - 'a']) {
        			alphabet += c[j];
        			taken[c[j] - 'a'] = true;
        		}
        	for (int j = 0; j < 26; ++j)
        		if (!taken[j])
        			alphabet += (char)(j + 'a');
        	System.out.println(alphabet);
        	boolean ok = true;
        	for (int j = 0; j < S.length; ++j)
        		if (i != j)
        			if (!less(S[i], S[j], alphabet))
        				ok = false;
        	if (ok)
        		ans.add(i);
        }
        System.out.println(ans);
        if (ans.isEmpty()) return new int[]{};
        int[] ansInt = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i)
        	ansInt[i] = ans.get(i);
        
        return ansInt;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(StringGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(getWinningStrings(new String[] {"a", "b", "c", "d"}), new int[] {0, 1, 2, 3 });
	}

	public void test1() {
		RETester.eq(getWinningStrings(new String[] {"aabbcc", "aaabbb", "aaaccc"}), new int[] {1, 2 });
	}

	public void test2() {
		RETester.eq(getWinningStrings(new String[] {"ab", "ba"}), new int[] { });
	}

	public void test3() {
		RETester.eq(getWinningStrings(new String[] {"xaocxsss", "oooxsoas", "xaooosss", "xaocssss", "coxaosxx"}), new int[] {1, 3, 4 });
	}

// END CUT HERE
}

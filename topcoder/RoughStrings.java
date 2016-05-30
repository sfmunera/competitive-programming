package topcoder;

import java.util.*;

public class RoughStrings {
	
	int[] roughness(int[] freq) {
		int[] res = {0, 1000};
        for (char c = 'a'; c <= 'z'; ++c) {
        	if (freq[c - 'a'] > res[0] && freq[c - 'a'] > 0)
        		res[0] = freq[c - 'a'];
        	if (freq[c - 'a'] < res[1] && freq[c - 'a'] > 0)
        		res[1] = freq[c - 'a'];
        }
        
        return res;
	}
	
    public int minRoughness(String s, int n) {
        int[] freq = new int[26];
        int[] freq2 = new int[100];
        
        for (char c : s.toCharArray())
        	++freq[c - 'a'];
        
        int n1 = 0;
        int n2 = 1000;
        char c1 = 'a';
        char c2 = 'a';
        for (char c = 'a'; c <= 'z'; ++c) {
        	if (freq[c - 'a'] > n1 && freq[c - 'a'] > 0) {
        		n1 = freq[c - 'a'];
        		c1 = c;
        	}
        	if (freq[c - 'a'] < n2 && freq[c - 'a'] > 0) {
        		n2 = freq[c - 'a'];
        		c2 = c;
        	}
        }
        
        for (int i = 0; i < freq.length; ++i)
        	++freq2[freq[i]];
        
        int f1 = freq2[freq[c1 - 'a']];
        int f2 = freq2[freq[c2 - 'a']];
        while (n > 0) {
        	if (f1 > f2)
        		--freq[c2 - 'a'];
        	else
        		--freq[c1 - 'a'];
        	--n;
        }
        
        int[] res = roughness(freq);
        return res[0] - res[1];
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RoughStrings.class, "test.*");
    }

	public void test0() {
		RETester.eq(minRoughness("aaaaabbc", 1), 3);
	}

	public void test1() {
		RETester.eq(minRoughness("aaaabbbbc", 5), 0);
	}

	public void test2() {
		RETester.eq(minRoughness("veryeviltestcase", 1), 2);
	}

	public void test3() {
		RETester.eq(minRoughness("gggggggooooooodddddddllllllluuuuuuuccckkk", 5), 3);
	}

	public void test4() {
		RETester.eq(minRoughness("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", 17), 0);
	}

	public void test5() {
		RETester.eq(minRoughness("bbbccca", 2), 0);
	}

// END CUT HERE
}

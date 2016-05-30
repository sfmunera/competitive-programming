
public class CyclicWords {
	public boolean isRotation(String s1, String s2) {
		String s = s1 + s1;
		return s1.length() == s2.length() && s.contains(s2);
	}
	
    public int differentCW(String[] words) {
    	int ans = 0;
        boolean[] seen = new boolean[words.length];
        for (int i = 0; i < words.length; ++i) {
        	if (seen[i])
        		continue;
        	++ans;
        	for (int j = i + 1; j < words.length; ++j)
        		if (!seen[j] && isRotation(words[i], words[j]))
        			seen[j] = true;
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CyclicWords.class, "test.*");
    }

	public void test0() {
		RETester.eq(differentCW(new String[] { "picture", "turepic", "icturep", "word", "ordw" }), 2);
	}

	public void test1() {
		RETester.eq(differentCW(new String[] { "ast", "ats", "tas", "tsa", "sat", "sta", "ttt" }), 3);
	}

	public void test2() {
		RETester.eq(differentCW(new String[] {"aaaa", "aaa", "aa", "aaaa", "aaaaa"}), 4);
	}

// END CUT HERE
}

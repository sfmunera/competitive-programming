
public class DengklekMakingChains {
	
	int toPattern(String s) {
		// 0: ..., 1: ..X, 2: .X., 3: .XX, 4: X.., 5: X.X, 6: XX., 7: XXX
    	int pattern = 0;
    	for (int j = 0; j < 3; ++j)
    		if (s.charAt(j) != '.')
    			pattern |= 1 << (2 - j);
    	
    	return pattern;
	}
	
	int value(String s) {
		int sum = 0;
		for (int i = 0; i < 3; ++i)
			if (s.charAt(i) != '.')
				sum += s.charAt(i) - '0';
		return sum;
	}
	
	int preffix(String s) {
		int sum = 0;
		if (s.contains("."))
			for (int j = 2; j >= 0; --j) {
				if (s.charAt(j) == '.')
					break;
				sum += s.charAt(j) - '0';
			}
		return sum;
	}
	
	int suffix(String s) {
		int sum = 0;
		if (s.contains("."))
			for (int j = 0; j < 3; ++j) {
				if (s.charAt(j) == '.')
					break;
				sum += s.charAt(j) - '0';
			}
		return sum;
	}
	
    public int maxBeauty(String[] chains) {
        int full = 0;
        int maxalone = 0;
        
        for (int i = 0; i < chains.length; ++i) {
        	int pat = toPattern(chains[i]);
        	if (pat == 7)
        		full += value(chains[i]);
        	if (pat == 2)
        		maxalone = Math.max(maxalone, value(chains[i]));
        }
        
        int max = 0;
        if (chains.length == 1 && chains[0].contains("."))
        	max = Math.max(preffix(chains[0]), suffix(chains[0]));
        
        for (int i = 0; i < chains.length; ++i)
        	for (int j = i + 1; j < chains.length; ++j) {
        		max = Math.max(max, preffix(chains[i]) + suffix(chains[j]));
    			max = Math.max(max, preffix(chains[j]) + suffix(chains[i]));
        	}
        
        return Math.max(maxalone, max + full);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(DengklekMakingChains.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxBeauty(new String[] {".15", "7..", "402", "..3"}), 19);
	}

	public void test1() {
		RETester.eq(maxBeauty(new String[] {"..1", "7..", "567", "24.", "8..", "234"}), 36);
	}

	public void test2() {
		RETester.eq(maxBeauty(new String[] {"...", "..."}), 0);
	}

	public void test3() {
		RETester.eq(maxBeauty(new String[] {"16.", "9.8", ".24", "52.", "3.1", "532", "4.4", "111"}), 28);
	}

	public void test4() {
		RETester.eq(maxBeauty(new String[] {"..1", "3..", "2..", ".7."}), 7);
	}

	public void test5() {
		RETester.eq(maxBeauty(new String[] {"412", "..7", ".58", "7.8", "32.", "6..", "351", "3.9", "985", "...", ".46"}), 58);
	}

// END CUT HERE
}

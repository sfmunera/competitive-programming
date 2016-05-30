
public class FavouriteDigits {

    public long findNext(long N, int digit1, int count1, int digit2, int count2) {
    	--N;
    	String str = String.valueOf(N);
        int len = Math.max(str.length(), count1 + count2);
        
        char[] ch = String.format("%0" + len + "d", N).toCharArray();
        
        if (digit1 > digit2) {
        	int t = digit1;
        	digit1 = digit2;
        	digit2 = t;
        	t = count1;
        	count1 = count2;
        	count2 = t;
        }
        
        long ans = -1;
        for (int i = len - 1; i >= 0; --i) {
        	int c1 = count1;
        	int c2 = count2;
        	boolean padding = true;
        	for (int j = 0; j < i; ++j) {
        		if (ch[j] > '0') padding = false;
        		if (ch[j] - '0' == digit1 && !padding && c1 > 0) --c1;
        		if (ch[j] - '0' == digit2 && !padding && c2 > 0) --c2;
        	}
        	char[] newch = ch.clone();
        	
        	char s = (char)(ch[i] + 1);
        	for (char c = s; c <= '9'; ++c) {
	        	newch[i] = c;
	        	int nc1 = c1;
	        	int nc2 = c2;
	        	if (c - '0' == digit1 && nc1 > 0) --nc1;
	        	if (c - '0' == digit2 && nc2 > 0) --nc2;
	        	
	        	if (len - i - 1 < nc1 + nc2) continue;
	        	for (int j = len - 1; j > i; --j) {
	        		if (nc2 > 0) {
	        			newch[j] = (char)(digit2 + '0');
	        			--nc2;
	        		} else if (nc1 > 0) {
	        			newch[j] = (char)(digit1 + '0');
	        			--nc1;
	        		} else
	        			newch[j] = '0';
	        	}
        	
	        	ans = Long.parseLong(String.valueOf(newch));
	        	break;
        	}
        	if (ans >= 0) break;
        }
        
        if (ans == -1) {
        	if (digit1 == 1 && count1 > 0) --count1;
        	if (digit2 == 1 && count2 > 0) --count2;
        	String tmp = "";
        	for (int i = 0; i < count2; ++i) tmp = digit2 + tmp;
        	for (int i = 0; i < count1; ++i) tmp = digit1 + tmp;
        	for (int i = 0; i < len - count1 - count2; ++i) tmp = 0 + tmp;
        	tmp = 1 + tmp;
        	
        	ans = Long.parseLong(tmp);
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FavouriteDigits.class, "test.*");
    }

	public void test0() {
		RETester.eq(findNext(47L, 1, 0, 2, 0), 47L);
	}

	public void test1() {
		RETester.eq(findNext(47L, 5, 0, 9, 1), 49L);
	}

	public void test2() {
		RETester.eq(findNext(47L, 5, 0, 3, 1), 53L);
	}

	public void test3() {
		RETester.eq(findNext(47L, 2, 1, 0, 2), 200L);
	}

	public void test4() {
		RETester.eq(findNext(123456789012345L, 1, 2, 2, 4), 123456789012422L);
	}

	public void test5() {
		RETester.eq(findNext(92L, 1, 1, 0, 0), 100L);
	}

// END CUT HERE
}

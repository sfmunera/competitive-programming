
public class LinearPolyominoCovering {
    public String findCovering(String region) {
    	char[] r = region.toCharArray();
    	int j = 0;
    	
    	while (j < r.length) {
    		if (r[j] != '.') {
	    		int k = r.length;
	    		for (int i = j; i < r.length; ++i)
	    			if (r[i] == '.') {
	    				k = i;
	    				break;
	    			}
	    		if ((k - j) % 2 == 1)
	    			return "impossible";
	    		while (k - j >= 4) {
	    			for (int i = 0; i < 4; ++i)
	    				r[j + i] = 'A';
	    			j += 4;
	    		}
	    		
	    		while (k - j >= 2) {
	    			for (int i = 0; i < 2; ++i)
	    				r[j + i] = 'B';
	    			j += 2;
	    		}
    		}
    		++j;
    	}
    	return String.valueOf(r);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LinearPolyominoCovering.class, "test.*");
    }

	public void test0() {
		RETester.eq(findCovering("XXXXXX"), "AAAABB");
	}

	public void test1() {
		RETester.eq(findCovering("XX.XX"), "BB.BB");
	}

	public void test2() {
		RETester.eq(findCovering("XXXX....XXX.....XX"), "impossible");
	}

	public void test3() {
		RETester.eq(findCovering("X"), "impossible");
	}

	public void test4() {
		RETester.eq(findCovering("XX.XXXXXXXXXX..XXXXXXXX...XXXXXX"), "BB.AAAAAAAABB..AAAAAAAA...AAAABB");
	}

// END CUT HERE
}

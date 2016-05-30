
public class LostParentheses {
    public int minResult(String e) {
        String[] parts = e.split("[-]");
        int ans = 0;
        boolean first = true;
        for (String p : parts) {
        	int sum = 0;
        	String[] parts2 = p.split("[+]");
        	for (String p2 : parts2)
        		sum += Integer.parseInt(p2);
        	if (first) {
        		ans = sum;
        		first = false;
        	} else
        		ans -= sum;
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LostParentheses.class, "test.*");
    }

	public void test0() {
		RETester.eq(minResult("55-50+40"), -35);
	}

	public void test1() {
		RETester.eq(minResult("10+20+30+40"), 100);
	}

	public void test2() {
		RETester.eq(minResult("00009-00009"), 0);
	}

// END CUT HERE
}

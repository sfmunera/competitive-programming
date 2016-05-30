
public class MissingParentheses {
    public int countCorrections(String par) {
    	int ans = 0;
        int cnt = 0;
        for (int i = 0; i < par.length(); ++i) {
        	if (par.charAt(i) == '(') ++cnt;
        	else --cnt;
        	
        	if (cnt == -1) {
        		cnt = 0;
        		++ans;
        	}
        }
        
        return ans + cnt;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MissingParentheses.class, "test.*");
    }

	public void test0() {
		RETester.eq(countCorrections("(()(()"), 2);
	}

	public void test1() {
		RETester.eq(countCorrections("()()(()"), 1);
	}

	public void test2() {
		RETester.eq(countCorrections("(())(()())"), 0);
	}

	public void test3() {
		RETester.eq(countCorrections("())(())((()))))()((())))()())())())()()()"), 7);
	}

// END CUT HERE
}

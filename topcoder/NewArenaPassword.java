
public class NewArenaPassword {
    public int minChange(String p, int K) {
    	int N = p.length();
    	char[] s = p.toCharArray();
    	
    	int ans1 = 0;
        for (int i = 0; i < K; ++i) {
        	if (s[i] != s[N - K + i]) {
        		++ans1;
        		//s[N - K + i] = s[i];
        	}
        }
        s = p.toCharArray();
    	
    	int ans2 = 0;
        for (int i = 0; i < K; ++i) {
        	if (s[i] != s[N - K + i]) {
        		++ans2;
        		s[N - K + i] = s[i];
        	}
        }
        return Math.min(ans1, ans2);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(NewArenaPassword.class, "test.*");
    }

	public void test0() {
		RETester.eq(minChange("topcoderopen", 5), 3);
	}

	public void test1() {
		RETester.eq(minChange("puyopuyo", 4), 0);
	}

	public void test2() {
		RETester.eq(minChange("loool", 3), 1);
	}

	public void test3() {
		RETester.eq(minChange("arena", 5), 0);
	}

	public void test4() {
		RETester.eq(minChange("amavckdkz", 7), 5);
	}

// END CUT HERE
}


public class FoxAndHandleEasy {
    public String isPossible(String S, String T) {
        for (int i = 0; i <= S.length(); ++i) {
        	String s = S.substring(0, i) + S + S.substring(i);
        	if (s.equals(T)) return "Yes";
        }
        return "No";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FoxAndHandleEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(isPossible("Ciel", "CieCiell"), "Yes");
	}

	public void test1() {
		RETester.eq(isPossible("Ciel", "FoxCiel"), "No");
	}

	public void test2() {
		RETester.eq(isPossible("FoxCiel", "FoxFoxCielCiel"), "Yes");
	}

	public void test3() {
		RETester.eq(isPossible("FoxCiel", "FoxCielCielFox"), "No");
	}

	public void test4() {
		RETester.eq(isPossible("Ha", "HaHaHaHa"), "No");
	}

	public void test5() {
		RETester.eq(isPossible("TheHandleCanBeVeryLong", "TheHandleCanBeVeryLong"), "No");
	}

	public void test6() {
		RETester.eq(isPossible("Long", "LongLong"), "Yes");
	}

// END CUT HERE
}

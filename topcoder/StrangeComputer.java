
public class StrangeComputer {
    public int setMemory(String mem) {
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < mem.length(); ++i)
        	if (mem.charAt(i) - '0' != cur) {
        		cur = 1 - cur;
        		++ans;
        	}
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(StrangeComputer.class, "test.*");
    }

	public void test0() {
		RETester.eq(setMemory("0011"), 1);
	}

	public void test1() {
		RETester.eq(setMemory("000"), 0);
	}

	public void test2() {
		RETester.eq(setMemory("0100"), 2);
	}

	public void test3() {
		RETester.eq(setMemory("111000111"), 3);
	}

// END CUT HERE
}

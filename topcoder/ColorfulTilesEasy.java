
public class ColorfulTilesEasy {
    public int theMin(String room) {
    	int ans = 0;
    	int cnt = 1;
        for (int i = 1; i < room.length(); ++i)
        	if (room.charAt(i) == room.charAt(i - 1))
        		++cnt;
        	else {
        		ans += cnt / 2;
        		cnt = 1;
        	}
        ans += cnt / 2;
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ColorfulTilesEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(theMin("RRRRRR"), 3);
	}

	public void test1() {
		RETester.eq(theMin("GGGGGGG"), 3);
	}

	public void test2() {
		RETester.eq(theMin("BBBYYYYYY"), 4);
	}

	public void test3() {
		RETester.eq(theMin("BRYGYBGRYR"), 0);
	}

	public void test4() {
		RETester.eq(theMin("RGGBBBRYYB"), 3);
	}

// END CUT HERE
}

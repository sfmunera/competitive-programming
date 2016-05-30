
public class RockStar {
    public int getNumSongs(int ff, int fs, int sf, int ss) {
    	int ans = 0;
        if (ff > 0 && fs > 0)
        	ans = ff + ss + 2 * Math.min(fs, sf) + (fs > sf ? 1 : 0);
        else if (ff > 0 && fs == 0)
        	ans = ff;
        else if (ff == 0 && fs > 0)
        	ans = ss + 2 * Math.min(fs, sf) + (fs > sf ? 1 : 0);
        else if (ff == 0 && fs == 0)
        	ans = ss + Math.min(sf, 1);
                
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RockStar.class, "test.*");
    }

	public void test0() {
		RETester.eq(getNumSongs(100, 0, 0, 200), 100);
	}

	public void test1() {
		RETester.eq(getNumSongs(0, 0, 20, 200), 201);
	}

	public void test2() {
		RETester.eq(getNumSongs(1, 2, 1, 1), 5);
	}

	public void test3() {
		RETester.eq(getNumSongs(192, 279, 971, 249), 999);
	}

// END CUT HERE
}

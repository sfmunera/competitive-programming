
public class RobotHerb {
	
	int[] dy = {-1, 0, 1, 0}; // NESW
	int[] dx = {0, 1, 0, -1};
	int[] a;
	long x, y;
	int dir;
	
	void simulate() {
		for (int i = 0; i < a.length; ++i) {
			x += dx[dir] * a[i];
			y += dy[dir] * a[i];
			dir = (dir + a[i]) % 4;
		}
	}
	
    public long getdist(int T, int[] _a) {
    	x = 0;
    	y = 0;
    	dir = 0;
    	a = _a;
    	long ans = 0;
    	simulate();
        long dist = Math.abs(x) + Math.abs(y);
    	if (dir == 0) {
    		return T * dist;
    	} else if (dir == 1 || dir == 3) {
    		x = 0;
        	y = 0;
        	dir = 0;
    		for (int i = 0; i < T % 4; ++i)
    			simulate();
    		return Math.abs(x) + Math.abs(y);
    	} else if (dir == 2) {
    		return (T % 2) * dist;
    	}
    	
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(RobotHerb.class, "test.*");
    }

	public void test0() {
		RETester.eq(getdist(1, new int[] {1,2,3}), 2L);
	}

	public void test1() {
		RETester.eq(getdist(100, new int[] {1}), 0L);
	}

	public void test2() {
		RETester.eq(getdist(5, new int[] {1,1,2}), 10L);
	}

	public void test3() {
		RETester.eq(getdist(1000000000, new int[] {100}), 100000000000L);
	}

	public void test4() {
		RETester.eq(getdist(570, new int[] {2013,2,13,314,271,1414,1732}), 4112L);
	}

// END CUT HERE
}

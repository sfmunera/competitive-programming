
public class WakingUp {
    public int maxSleepiness(int[] period, int[] start, int[] volume, int D) {
        int N = 2520;
        
        int x = 0;
        int S = 0;
        for (int t = 1; t <= N; ++t) {
        	x += D;
        	for (int i = 0; i < period.length; ++i) {
        		if (t >= start[i] && (t - start[i]) % period[i] == 0) {
        			x -= volume[i];
        		}
        	}
        	S = Math.min(S, x);
        }
        
        return x < 0 ? -1 : -S;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(WakingUp.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxSleepiness(new int[] {2, 3}, new int[] {1, 2}, new int[] {3, 4}, 3), 2);
	}

	public void test1() {
		RETester.eq(maxSleepiness(new int[] {1}, new int[] {1}, new int[] {17}, 17), 0);
	}

	public void test2() {
		RETester.eq(maxSleepiness(new int[] {1}, new int[] {1}, new int[] {23}, 17), -1);
	}

	public void test3() {
		RETester.eq(maxSleepiness(new int[] {9, 2, 5, 5, 7}, new int[] {6, 1, 4, 1, 6}, new int[] {71, 66, 7, 34, 6}, 50), 78);
	}

	public void test4() {
		RETester.eq(maxSleepiness(new int[] {5, 6, 5, 3, 8, 3, 4}, new int[] {1, 1, 3, 2, 6, 3, 3}, new int[] {42, 85, 10, 86, 21, 78, 38}, 88), -1);
	}

// END CUT HERE
}

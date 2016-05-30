
public class MinimumSquare {
	
	boolean check(long L, int[] x, int[] y, int K) {
		
		for (int i = 0; i < x.length; ++i) {
			boolean[] possibleX = new boolean[x.length];
			for (int j = 0; j < x.length; ++j)
				if (x[j] >= x[i] && x[j] - x[i] <= L - 2)
					possibleX[j] = true;
			for (int l = 0; l < x.length; ++l) {
				int cnt = 0;
				for (int j = 0; j < x.length; ++j)
					if (possibleX[l] && possibleX[j] && y[j] >= y[l] && y[j] - y[l] <= L - 2) {
						++cnt;
					}
				if (cnt >= K) return true;
			}
		}
		
		return false;
	}
	
    public long minArea(int[] x, int[] y, int K) {
        long lo = 0L;
        long hi = 3L * (long) (1e9);

        while (lo < hi) {
        	long mid = (lo + hi) / 2;
        	if (check(mid, x, y, K))
        		hi = mid;
        	else
        		lo = mid + 1;
        }
        
        return lo * lo;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MinimumSquare.class, "test.*");
    }

	public void test0() {
		RETester.eq(minArea(new int[] {0, 3}, new int[] {0, 7}, 2), 81L);
	}

	public void test1() {
		RETester.eq(minArea(new int[] {-4, 3, 1}, new int[] {3 , -1, -2}, 2), 16L);
	}

	public void test2() {
		RETester.eq(minArea(new int[] {0, 0, 1, 1, 2, 2}, new int[] {0, 1, 0, 1, 0, 1}, 4), 9L);
	}

	public void test3() {
		RETester.eq(minArea(new int[] {1000000000, 1000000000, 1000000000, -1000000000, -1000000000, -1000000000}, new int[] {1000000000, 0, -1000000000, 1000000000, 0, -1000000000}, 3), 4000000008000000004L);
	}

	public void test4() {
		RETester.eq(minArea(new int[] {-47881, 28623, 1769, -38328, -16737, 16653, -23181, 37360, 41429, 26282, 254, 728, 8299, -41080, -29498, 17488, -23937, -11, 33319, 25232}, new int[] {-46462, 48985, -43820, -19587, -33593, -28337, 13667, -48131, -5568, -2332, -41918, -31370, -3695, 42599, -37788, -40096, 39049, 25045, -2122, 3874}, 8), 1695545329L);
	}

// END CUT HERE
}

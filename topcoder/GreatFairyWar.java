
public class GreatFairyWar {
    public int minHP(int[] dps, int[] hp) {
    	int N = dps.length;
        int[] sum = new int[N];
        
        for (int i = 0; i < N; ++i)
        	sum[i] = dps[i];
        
        for (int i = N - 1; i > 0; --i)
        	sum[i - 1] += sum[i];
        
        int ans = 0;
        for (int i = 0; i < N; ++i)
        	ans += sum[i] * hp[i];
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(GreatFairyWar.class, "test.*");
    }

	public void test0() {
		RETester.eq(minHP(new int[] {1,2}, new int[] {3,4}), 17);
	}

	public void test1() {
		RETester.eq(minHP(new int[] {1,1,1,1,1,1,1,1,1,1}, new int[] {1,1,1,1,1,1,1,1,1,1}), 55);
	}

	public void test2() {
		RETester.eq(minHP(new int[] {20,12,10,10,23,10}, new int[] {5,7,7,5,7,7}), 1767);
	}

	public void test3() {
		RETester.eq(minHP(new int[] {5,7,7,5,7,7}, new int[] {20,12,10,10,23,10}), 1998);
	}

	public void test4() {
		RETester.eq(minHP(new int[] {30,2,7,4,7,8,21,14,19,12}, new int[] {2,27,18,19,14,8,25,13,21,30}), 11029);
	}

	public void test5() {
		RETester.eq(minHP(new int[] {1}, new int[] {1}), 1);
	}

// END CUT HERE
}

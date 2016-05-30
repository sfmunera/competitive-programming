
public class Straights {
    public int howMany(int[] hand, int k) {
    	int ans = 0;
        for (int i = 0; i <= 13 - k; ++i) {
        	int sum = 1;
        	for (int j = 0; j < k; ++j)
        		sum *= hand[i + j];
        	ans += sum;
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Straights.class, "test.*");
    }

	public void test0() {
		RETester.eq(howMany(new int[] {0,3,1,2,0,0,0,0,0,0,0,0,0}, 2), 5);
	}

	public void test1() {
		RETester.eq(howMany(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1}, 5), 9);
	}

	public void test2() {
		RETester.eq(howMany(new int[] {4,4,4,4,4,4,4,4,4,4,4,4,4}, 13), 67108864);
	}

	public void test3() {
		RETester.eq(howMany(new int[] {4,0,4,0,4,0,4,0,4,0,4,0,4}, 2), 0);
	}

	public void test4() {
		RETester.eq(howMany(new int[] {1,2,3,4,1,2,3,4,1,2,3,4,1}, 1), 31);
	}

// END CUT HERE
}


import java.util.*;

public class BootsExchange {
    public int leastAmount(int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int N = left.length;
        
        int cnt = 0;
        int k = 0;
        for (int i = 0; i < N; ++i)
        	for (int j = k; j < N; ++j) {
        		if (left[i] == right[j]) {
        			++cnt;
        			k = j + 1;
        			break;
        		}
        	}
        return N - cnt;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(BootsExchange.class, "test.*");
    }

	public void test0() {
		RETester.eq(leastAmount(new int[] {1, 3, 1}, new int[] {2, 1, 3}), 1);
	}

	public void test1() {
		RETester.eq(leastAmount(new int[] {1, 3}, new int[] {2, 2}), 2);
	}

	public void test2() {
		RETester.eq(leastAmount(new int[] {1, 2, 3, 4, 5, 6, 7}, new int[] {2, 4, 6, 1, 3, 7, 5}), 0);
	}

// END CUT HERE
}

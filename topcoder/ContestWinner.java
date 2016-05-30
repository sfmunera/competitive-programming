
import java.util.*;

public class ContestWinner {
    public int getWinner(int[] events) {
        int[] cnt = new int[1000001];
        int[] last = new int[1000001];
        
        int max = 0;
        for (int i = 0; i < events.length; ++i) {
        	++cnt[events[i]];
        	max = Math.max(max, cnt[events[i]]);
        	last[events[i]] = i;
        }

        //System.out.println(max);
        int best = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= 1000000; ++i) {
        	if (cnt[i] == max && last[i] < best) {
        		best = last[i];
        		res = i;
        	}
        }
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ContestWinner.class, "test.*");
    }

	public void test0() {
		RETester.eq(getWinner(new int[] {4,7,4,1}), 4);
	}

	public void test1() {
		RETester.eq(getWinner(new int[] {10,20,30,40,50}), 10);
	}

	public void test2() {
		RETester.eq(getWinner(new int[] {123,123,456,456,456,123}), 456);
	}

	public void test3() {
		RETester.eq(getWinner(new int[] {1,2,2,3,3,3,4,4,4,4}), 4);
	}

// END CUT HERE
}

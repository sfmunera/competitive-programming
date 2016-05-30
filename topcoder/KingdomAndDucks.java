
import java.util.*;

public class KingdomAndDucks {
    public int minDucks(int[] duckTypes) {
    	Set<Integer> set = new HashSet<Integer>();
    	
        Arrays.sort(duckTypes);
        int max = 1;
        int cnt = 1;
        set.add(duckTypes[0]);
        for (int i = 1; i < duckTypes.length; ++i) {
        	if (duckTypes[i - 1] == duckTypes[i]) {
        		++cnt;
        	} else {
        		max = Math.max(max, cnt);
        		cnt = 1;
        	}
        	set.add(duckTypes[i]);
        }
        max = Math.max(max, cnt);
        
        return max * set.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KingdomAndDucks.class, "test.*");
    }

	public void test0() {
		RETester.eq(minDucks(new int[] {5, 8}), 2);
	}

	public void test1() {
		RETester.eq(minDucks(new int[] {4, 7, 4, 7, 4}), 6);
	}

	public void test2() {
		RETester.eq(minDucks(new int[] {17, 17, 19, 23, 23, 19, 19, 17, 17}), 12);
	}

	public void test3() {
		RETester.eq(minDucks(new int[] {50}), 1);
	}

	public void test4() {
		RETester.eq(minDucks(new int[] {10, 10, 10, 10, 10}), 5);
	}

// END CUT HERE
}


import java.util.*;

public class MyLongCake {
    public int cut(int n) {
    	
    	HashSet<Integer> cuts = new HashSet<Integer>();
    	
        for (int d = 1; d * d <= n; ++d)
        	if (n % d == 0) {
        		int L1 = d;
        		int L2 = n / d;
        		if (L1 > 1)
        			for (int i = 0; i < n; i += L1)
        				cuts.add(i);
        		if (L2 > 1)
        			for (int i = 0; i < n; i += L2)
        				cuts.add(i);
        	}
        
        return cuts.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(MyLongCake.class, "test.*");
    }

	public void test0() {
		RETester.eq(cut(6), 4);
	}

	public void test1() {
		RETester.eq(cut(3), 1);
	}

	public void test2() {
		RETester.eq(cut(15), 7);
	}

	public void test3() {
		RETester.eq(cut(100000), 60000);
	}

// END CUT HERE
}

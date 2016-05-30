
import java.util.*;

public class UnsortedSequence {
    public int[] getUnsorted(int[] s) {
        Arrays.sort(s);
        
        boolean changed = false;
        for (int i = s.length - 1; i >= 1; --i)
        	if (s[i] != s[i - 1]) {
        		changed = true;
        		int t = s[i];
        		s[i] = s[i - 1];
        		s[i - 1] = t;
        		break;
        	}
        
        if (changed)
        	return s;
        else
        	return new int[]{};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(UnsortedSequence.class, "test.*");
    }

	public void test0() {
		RETester.eq(getUnsorted(new int[] {1,2}), new int[] {2, 1 });
	}

	public void test1() {
		RETester.eq(getUnsorted(new int[] {1,2,3}), new int[] {1, 3, 2 });
	}

	public void test2() {
		RETester.eq(getUnsorted(new int[] {7,2,2}), new int[] {2, 7, 2 });
	}

	public void test3() {
		RETester.eq(getUnsorted(new int[] {1000}), new int[] { });
	}

	public void test4() {
		RETester.eq(getUnsorted(new int[] {1,1}), new int[] { });
	}

	public void test5() {
		RETester.eq(getUnsorted(new int[] {1,2,4,3}), new int[] {1, 2, 4, 3 });
	}

	public void test6() {
		RETester.eq(getUnsorted(new int[] {2,8,5,1,10,5,9,9,3,10,5,6,6,2,8,2,10}), new int[] {1, 2, 2, 2, 3, 5, 5, 5, 6, 6, 8, 8, 9, 10, 9, 10, 10 });
	}

// END CUT HERE
}

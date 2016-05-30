import java.util.*;

public class PairingPawns {
    public int savedPawnCount(int[] start) {
        int n = start.length;
        
        for (int i = n - 1; i > 0; --i) {
        	while (start[i] >= 2) {
        		start[i] -= 2;
        		++start[i - 1];
        	}
        }
        return start[0];
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PairingPawns.class, "test.*");
    }

	public void test0() {
		RETester.eq(savedPawnCount(new int[] {0,2}), 1);
	}

	public void test1() {
		RETester.eq(savedPawnCount(new int[] {10,3}), 11);
	}

	public void test2() {
		RETester.eq(savedPawnCount(new int[] {0,0,0,8}), 1);
	}

	public void test3() {
		RETester.eq(savedPawnCount(new int[] {0,1,1,2}), 1);
	}

	public void test4() {
		RETester.eq(savedPawnCount(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,123456}), 0);
	}

	public void test5() {
		RETester.eq(savedPawnCount(new int[] {1000,2000,3000,4000,5000,6000,7000,8000}), 3921);
	}

// END CUT HERE
}

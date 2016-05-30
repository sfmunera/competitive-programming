
import java.util.*;

public class ANDEquation {
    public int restoreY(int[] A) {
        int res = -1;
        int n = A.length;
        
        for (int i = 0; i < n; ++i) {
        	int y = A[i];
        	int possible = 0;
        	boolean first = true;
        	for (int j = 0; j < n; ++j) {
        		
        		if (i != j) {
        			if (first) {
            			possible = A[j];
            			first = false;
        			} else
        				possible &= A[j];
        		}
        	}
        	if (possible == y)
        		res = y;
        }
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ANDEquation.class, "test.*");
    }

	public void test0() {
		RETester.eq(restoreY(new int[] {
			1, 3, 5}
			),
			1);
	}

	public void test1() {
		RETester.eq(restoreY(new int[] {
			31, 7}
			),
			-1);
	}

	public void test2() {
		RETester.eq(restoreY(new int[] {
			31, 7, 7}
			),
			7);
	}

	public void test3() {
		RETester.eq(restoreY(new int[] {
			1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,
			0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1}),
			0);
	}

	public void test4() {
		RETester.eq(restoreY(new int[] {
			191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,
			191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,
			191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,
			191411,191411,191411}),
			191411);
	}

	public void test5() {
		RETester.eq(restoreY(new int[] {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211}), -1);
	}

	public void test6() {
		RETester.eq(restoreY(new int[] {2, 3, 7, 19}), -1);
	}

// END CUT HERE
}

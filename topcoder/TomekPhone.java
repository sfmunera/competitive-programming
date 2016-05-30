
import java.util.*;

public class TomekPhone {
    public int minKeystrokes(int[] f, int[] ks) {
        int N = f.length;
        int M = ks.length;
        
        int sum = 0;
        for (int i = 0; i < M; ++i)
        	sum += ks[i];
        if (sum < N)
        	return -1;
        
        int ans = 0;
        Arrays.sort(f);
        Arrays.sort(ks);
        int max = ks[M - 1];
        int ind = N - 1;
        for (int k = 0; k < max; ++k) {
        	for (int i = 0; i < M; ++i) {
        		if (ks[i] > k && ind >= 0) {
        			ans += f[ind] * (k + 1);
        			--ind;
        		}
        	}
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TomekPhone.class, "test.*");
    }

	public void test0() {
		RETester.eq(minKeystrokes(new int[] {7,3,4,1}, new int[] {2,2}), 19);
	}

	public void test1() {
		RETester.eq(minKeystrokes(new int[] {13,7,4,20}, new int[] {2,1}), -1);
	}

	public void test2() {
		RETester.eq(minKeystrokes(new int[] {11,23,4,50,1000,7,18}, new int[] {3,1,4}), 1164);
	}

	public void test3() {
		RETester.eq(minKeystrokes(new int[] {100,1000,1,10}, new int[] {50}), 1234);
	}

	public void test4() {
		RETester.eq(minKeystrokes(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}, new int[] {10,10,10,10,10,10,10,10}), 3353);
	}

// END CUT HERE
}

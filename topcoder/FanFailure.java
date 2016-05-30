
import java.util.*;

public class FanFailure {
    public int[] getRange(int[] capacities, int minCooling) {
        Arrays.sort(capacities);
        int N = capacities.length;
        
        int sum = 0;
        int ind = N;
        
        for (int i = N - 1; i >= 0; --i) {
        	if (sum + capacities[i] <= minCooling) {
        		sum += capacities[i];
        		ind = i;
        	} else {
        		break;
        	}
        }
        
        int ans1 = ind - 1;
        
        ind = -1;
        sum = 0;
        for (int i = 0; i < N; ++i)
        	if (sum + capacities[i] <= minCooling) {
        		sum += capacities[i];
        		ind = i;
        	} else {
        		break;
        	}
        int ans2 = N - ind - 2;
        
        return new int[]{ans1, ans2};
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FanFailure.class, "test.*");
    }

	public void test0() {
		RETester.eq(getRange(new int[] {1,2,3}, 2), new int[] { 2,  1 });
	}

	public void test1() {
		RETester.eq(getRange(new int[] {8,5,6,7}, 22), new int[] { 0,  0 });
	}

	public void test2() {
		RETester.eq(getRange(new int[] {676, 11, 223, 413, 823, 122, 547, 187, 28}, 1000), new int[] { 7,  2 });
	}

	public void test3() {
		RETester.eq(getRange(new int[] {
			955, 96, 161, 259, 642, 242, 772, 369, 311, 785,
			92, 991, 620, 394, 128, 774, 973, 94, 681, 771,
			916, 373, 523, 100, 220, 993, 472, 798, 132, 361,
			33, 362, 573, 624, 722, 520, 451, 231, 37, 921,
			408, 170, 303, 559, 866, 412, 339, 757, 822, 192},
			3619), new int[] { 46,  30 });
	}

// END CUT HERE
}


import java.util.*;

public class SlimeXSlimesCity {
    public int merge(int[] population) {
        Arrays.sort(population);
        int N = population.length;
        int ans = 0;
        
        for (int i = 0; i < N; ++i) {
        	long sum = population[i];
        	boolean ok = true;
        	for (int j = 0; j < N; ++j) {
        		if (i == j) continue;
        		if (population[j] > sum) {
        			ok = false;
        			break;
        		}
        		sum += population[j];
        	}
        	if (ok)
        		++ans;
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SlimeXSlimesCity.class, "test.*");
    }

	public void test0() {
		RETester.eq(merge(new int[] {2, 3, 4}), 2);
	}

	public void test1() {
		RETester.eq(merge(new int[] {1, 2, 3}), 2);
	}

	public void test2() {
		RETester.eq(merge(new int[] {8,2,3,8}), 2);
	}

	public void test3() {
		RETester.eq(merge(new int[] {1000000000, 999999999, 999999998, 999999997}), 3);
	}

	public void test4() {
		RETester.eq(merge(new int[] {1,1,1}), 3);
	}

	public void test5() {
		RETester.eq(merge(new int[] {1, 2, 4, 6, 14, 16, 20}), 3);
	}

// END CUT HERE
}

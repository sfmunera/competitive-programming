
import java.util.*;

public class ImportantTasks {
    public int maximalCost(int[] complexity, int[] computers) {
        Arrays.sort(complexity);
        Arrays.sort(computers);
        
        int ans = 0;
        int j = complexity.length - 1;
        for (int i = computers.length - 1; i >= 0; --i) {
        	while (j >= 0 && complexity[j] > computers[i])
        		--j;
        	if (j >= 0)
        		++ans;
        	--j;
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ImportantTasks.class, "test.*");
    }

	public void test0() {
		RETester.eq(maximalCost(new int[] {1,2,3}, new int[] {2,2,2}), 2);
	}

	public void test1() {
		RETester.eq(maximalCost(new int[] {1,2,3}, new int[] {3}), 1);
	}

	public void test2() {
		RETester.eq(maximalCost(new int[] {3,5,1,7}, new int[] {9,4,1,1,1}), 3);
	}

	public void test3() {
		RETester.eq(maximalCost(new int[] {5,2,7,8,6,4,2,10,2,3}, new int[] {4,1,3,6,2,10,11,1,1,3,4,2}), 8);
	}

	public void test4() {
		RETester.eq(maximalCost(new int[] {100}, new int[] {100,100}), 1);
	}

// END CUT HERE
}

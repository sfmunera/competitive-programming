
import java.util.*;

public class Suminator {
	
	long simulate(int[] program) {
		Stack<Long> S = new Stack<Long>();
        
        for (long x : program) {
        	if (x == 0) {
        		long sum = 0;
        		if (!S.isEmpty())
        			sum += S.pop();
        		if (!S.isEmpty())
        			sum += S.pop();
        		S.push(sum);
        	} else
        		S.push(x);
        }

        return S.pop();
	}
	
    public int findMissing(int[] program, int wantedResult) {
        
    	int pos = 0;
    	for (int i = 0; i < program.length; ++i)
    		if (program[i] == -1) {
    			pos = i;
    			break;
    		}
        
    	program[pos] = 0;
    	if (simulate(program) ==  wantedResult)
    		return 0;
    	
    	program[pos] = 1;
    	long tmp = simulate(program);
    	if (tmp == wantedResult)
    		return 1;
    	
    	long ans = wantedResult - tmp + 1;
    	if (ans < 0 || ans > 1000000000)
    		return -1;
    	program[pos] = (int)ans;
    	if (simulate(program) == wantedResult)
    		return (int)ans;
    	return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Suminator.class, "test.*");
    }

	public void test0() {
		RETester.eq(findMissing(new int[] {7,-1,0}, 10), 3);
	}

	public void test1() {
		RETester.eq(findMissing(new int[] {100, 200, 300, 0, 100, -1}, 600), 0);
	}

	public void test2() {
		RETester.eq(findMissing(new int[] {-1, 7, 3, 0, 1, 2, 0, 0}, 13), 0);
	}

	public void test3() {
		RETester.eq(findMissing(new int[] {-1, 8, 4, 0, 1, 2, 0, 0}, 16), -1);
	}

	public void test4() {
		RETester.eq(findMissing(new int[] {1000000000, 1000000000, 1000000000,  1000000000, -1, 0, 0, 0, 0}, 1000000000), -1);
	}

	public void test5() {
		RETester.eq(findMissing(new int[] {7, -1, 3, 0}, 3), -1);
	}

// END CUT HERE
}

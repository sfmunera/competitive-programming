import java.util.*;

public class FibonacciSequence {
    public int numFibs(int a, int b) {
        int n1 = 1;
        int n2 = 1;
        int n3 = n1 + n2;
        
        Set<Integer> fib = new HashSet<Integer>();
        fib.add(n1); fib.add(n2);
        
        while (n3 <= 1000) {
        	fib.add(n3);
        	n1 = n2;
        	n2 = n3;
        	n3 = n1 + n2;
        }
        
        int cnt = 0;
        for (int i = a; i <= b; ++i)
        	if (fib.contains(i))
        		++cnt;
        return cnt;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(FibonacciSequence.class, "test.*");
    }

	public void test0() {
		RETester.eq(numFibs(2, 5), 3);
	}

	public void test1() {
		RETester.eq(numFibs(12, 13), 1);
	}

	public void test2() {
		RETester.eq(numFibs(13, 13), 1);
	}

// END CUT HERE
}

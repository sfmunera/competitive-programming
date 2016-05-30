
import java.util.*;

public class AmebaDiv1 {
    public int count(int[] X) {
    	boolean[] possible = new boolean[X.length];
        for (int i = 0; i < X.length; ++i) {
        	int s = X[i];
        	for (int j = 0; j < X.length; ++j)
        		if (X[j] == s)
        			s *= 2;
        	for (int j = 0; j < X.length; ++j)
        		if (s == X[j])
        			possible[j] = true;
        }
        
        HashSet<Integer> notPossible = new HashSet<Integer>();
        for (int i = 0; i < X.length; ++i)
        	if (!possible[i])
        		notPossible.add(X[i]);
        
        return notPossible.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(AmebaDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(count(new int[] {3,2,1}), 2);
	}

	public void test1() {
		RETester.eq(count(new int[] {2,2,2,2,2,2,4,2,2,2}), 2);
	}

	public void test2() {
		RETester.eq(count(new int[] {1,2,4,8,16,32,64,128,256,1024,2048}), 11);
	}

	public void test3() {
		RETester.eq(count(new int[] {854,250,934,1000,281,250,281,467,854,562,934,1000,854,500,562}), 7);
	}

// END CUT HERE
}

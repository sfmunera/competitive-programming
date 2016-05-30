
import java.util.*;

public class TaroFriends {
	
	int simulate(int cut, int[] c, int X) {
		int[] tmp = new int[c.length];
		for (int i = 0; i < cut; ++i)
			tmp[i] = c[i] + X;
		for (int i = cut; i < c.length; ++i)
			tmp[i] = c[i] - X;
		
		Arrays.sort(tmp);
		
		return tmp[c.length - 1] - tmp[0];
	}
	
    public int getNumber(int[] coordinates, int X) {
        Arrays.sort(coordinates);
        int N = coordinates.length;
        
        int ans = Integer.MAX_VALUE;
        for (int cut = 0; cut < N; ++cut)
        	ans = Math.min(ans, simulate(cut, coordinates, X));
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TaroFriends.class, "test.*");
    }

	public void test0() {
		RETester.eq(getNumber(new int[] {-3, 0, 1}, 3), 3);
	}

	public void test1() {
		RETester.eq(getNumber(new int[] {4, 7, -7}, 5), 4);
	}

	public void test2() {
		RETester.eq(getNumber(new int[] {-100000000, 100000000}, 100000000), 0);
	}

	public void test3() {
		RETester.eq(getNumber(new int[] {3, 7, 4, 6, -10, 7, 10, 9, -5}, 7), 7);
	}

	public void test4() {
		RETester.eq(getNumber(new int[] {-4, 0, 4, 0}, 4), 4);
	}

	public void test5() {
		RETester.eq(getNumber(new int[] {7}, 0), 0);
	}

// END CUT HERE
}

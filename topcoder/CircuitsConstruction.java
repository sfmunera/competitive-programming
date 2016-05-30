package topcoder;

import java.util.*;

public class CircuitsConstruction {
	
	String circuit;
	int[] conds;
	int[] index;
	
	int solve(int l, int r) {
		if (l > r) return -1;
		if (l == r) {
			if (circuit.charAt(l) == 'X')
				return conds[index[l]];
			else return -1;
		}
		
		if (circuit.charAt(l) == 'X')
			return -1;
		
		if (r - l + 1 < 3) return -1;
		char type = circuit.charAt(l);
		
		int ans = 0;
		for (int i = l + 1; i < r; ++i) {
			int ans1 = solve(l + 1, i);
			int ans2 = solve(i + 1, r);
			
			if (type == 'A')
				ans = Math.max(ans, ans1 + ans2);
			else
				ans = Math.max(ans, Math.max(ans1, ans2));
		}
		
		return ans;
	}
	
    public int maximizeResistance(String _circuit, int[] _conductors) {
        circuit = _circuit;
        conds = _conductors.clone();
        index = new int[circuit.length()];
        
        Arrays.fill(index, -1);
        
        int ind = 0;
        for (int i = 0; i < circuit.length(); ++i) {
        	if (circuit.charAt(i) == 'X')
        		index[i] = ind++;
        }
        
        return solve(0, circuit.length() - 1);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CircuitsConstruction.class, "test.*");
    }

	public void test0() {
		RETester.eq(maximizeResistance("BXBXX", new int[] {8, 2, 3}), 8);
	}

	public void test1() {
		RETester.eq(maximizeResistance("AAXXAXAXX", new int[] {1, 1, 2, 8, 10}), 22);
	}

	public void test2() {
		RETester.eq(maximizeResistance("AXBXX", new int[] {8, 2, 3}), 11);
	}

	public void test3() {
		RETester.eq(maximizeResistance("BAAXBXXBXAXXBBAXXBXXAAXXX", new int[] {17, 7, 21, 102, 56, 72, 88, 15, 9, 192, 16, 8, 30}), 454);
	}

// END CUT HERE
}

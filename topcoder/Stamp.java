package topcoder;

public class Stamp {
	
	int stampCost, pushCost, N;
	String desiredColor;
	char[] colors = new char[]{'R', 'G', 'B'};
	int INF = 1000000000;
	
	int go(int L, String cur, char color, int cost) {
		int ind = cur.indexOf('*');
		
		if (ind < 0) {
			boolean ok = true;
			for (int i = 0; i < N; ++i) {
				if (desiredColor.charAt(i) == '*')
					continue;
				if (desiredColor.charAt(i) != cur.charAt(i)) {
					ok = false;
					break;
				}
			}
			return ok ? cost: INF;
		}
		
		int ans = INF;
		for (int i = 0; i <= N - L; ++i) {
			boolean ok = true;
			boolean containsStar = false;
			for (int j = 0; j < L; ++j) {
				if (cur.charAt(i + j) != '*' && cur.charAt(i + j) != color) {
					ok = false;
					break;
				}
				if (cur.charAt(i + j) == '*')
					containsStar = true;
			}
			if (ok && containsStar) {
				char[] str = cur.toCharArray();
				for (int j = 0; j < L; ++j)
					str[i + j] = color;
				for (int c = 0; c < 3; ++c)
	        		ans = Math.min(ans, go(L, String.valueOf(str), colors[c], cost + pushCost));
			}
		}
		return ans;
	}
	
    public int getMinimumCost(String _desiredColor, int _stampCost, int _pushCost) {
    	desiredColor = _desiredColor;
    	stampCost = _stampCost;
    	pushCost = _pushCost;
    	N = desiredColor.length();
    	
    	int ans = INF;
    	String cur = String.format("%" + N + "s", ' ').replace(' ', '*');
        for (int L = 1; L <= N; ++L) {
        	int cost = L * stampCost;
        	
        	for (int c = 0; c < 3; ++c)
        		ans = Math.min(ans, go(L, cur, colors[c], cost));
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Stamp.class, "test.*");
    }

	public void test0() {
		RETester.eq(getMinimumCost("RRGGBB", 1, 1), 5);
	}

	public void test1() {
		RETester.eq(getMinimumCost("R**GB*", 1, 1), 5);
	}

	public void test2() {
		RETester.eq(getMinimumCost("BRRB", 2, 7), 30);
	}

	public void test3() {
		RETester.eq(getMinimumCost("R*RR*GG", 10, 58), 204);
	}

	public void test4() {
		RETester.eq(getMinimumCost("*B**B**B*BB*G*BBB**B**B*", 5, 2), 33);
	}

	public void test5() {
		RETester.eq(getMinimumCost("*R*RG*G*GR*RGG*G*GGR***RR*GG", 7, 1), 30);
	}

// END CUT HERE
}

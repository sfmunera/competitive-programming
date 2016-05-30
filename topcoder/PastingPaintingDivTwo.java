package topcoder;

public class PastingPaintingDivTwo {
    public long countColors(String[] c, int T) {
        int R = c.length;
        int C = c[0].length();
        int N = 0;
        
        for (int i = 0; i < R; ++i)
        	for (int j = 0; j < C; ++j)
        		if (c[i].charAt(j) == 'B')
        			++N;
        int I = 0;
        for (int i = 0; i < R - 1; ++i)
        	for (int j = 0; j < C - 1; ++j)
        		if (c[i].charAt(j) == 'B' && c[i + 1].charAt(j + 1) == 'B')
        			++I;
        return (long)N * T - (long)I * (T - 1);
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PastingPaintingDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(countColors(new String[] {
			"..B",
			"B..",
			"BB."
			},
			3), 10L);
	}

	public void test1() {
		RETester.eq(countColors(new String[] {
			"B...",
			"....",
			"....",
			"...B"
			},
			2), 4L);
	}

	public void test2() {
		RETester.eq(countColors(new String[] {"BBB"}, 10000), 30000L);
	}

	public void test3() {
		RETester.eq(countColors(new String[] {"."}, 1000000000), 0L);
	}

	public void test4() {
		RETester.eq(countColors(new String[] {
			"BB.",
			".B."
			},
			100), 201L);
	}

	public void test5() {
		RETester.eq(countColors(new String[] {
			"..........B..........",
			".........B.B.........",
			"........B...B........",
			".......B.....B.......",
			"......B..B.B..B......",
			".....B...B.B...B.....",
			"....B...........B....",
			"...B...B.....B...B...",
			"..B.....BBBBBB....B..",
			".B..........BB.....B.",
			"BBBBBBBBBBBBBBBBBBBBB"
			},
			1000000000), 21000000071L);
	}

// END CUT HERE
}

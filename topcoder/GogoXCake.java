
public class GogoXCake {
    public String solve(String[] scake, String[] scutter) {
    	int R = scake.length;
    	int C = scake[0].length();
    	int r = scutter.length;
    	int c = scutter[0].length();
        char[][] cake = new char[R][C];
        char[][] cutter = new char[r][c];
        
        for (int i = 0; i < R; ++i)
        	cake[i] = scake[i].toCharArray();
        for (int i = 0; i < r; ++i)
        	cutter[i] = scutter[i].toCharArray();
        
        for (int i = 0; i <= R - r; ++i)
        	for (int j = 0; j <= C - c; ++j) {
        		boolean ok = true;
        		for (int k = 0; k < r; ++k)
        			for (int l = 0; l < c; ++l)
        				if (cutter[k][l] == '.' && cake[i + k][j + l] == 'X')
        					ok = false;
        		if (ok)
        			for (int k = 0; k < r; ++k)
            			for (int l = 0; l < c; ++l)
            				if (cutter[k][l] == '.')
            					cake[i + k][j + l] = 'X';
        	}
        
        for (int i = 0; i < R; ++i)
        	for (int j = 0; j < C; ++j)
        		if (cake[i][j] == '.')
        			return "NO";
        return "YES";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(GogoXCake.class, "test.*");
    }

	public void test0() {
		RETester.eq(solve(new String[] {
			"X.X"
			,"..."
			,"..."
			,"X.X"},
			new String[] {
			".X"
			,".."
			,"X."}),
			"YES");
	}

	public void test1() {
		RETester.eq(solve(new String[] {
			"..XX"
			,"...X"
			,"X..."
			,"XX.."},
			new String[] {
			".."
			,".."}),
			"NO");
	}

	public void test2() {
		RETester.eq(solve(new String[] {"...X..."}, new String[] {"..."}), "YES");
	}

	public void test3() {
		RETester.eq(solve(new String[] {
			".X."
			,"X.X"
			,".X."},
			new String[] {"."}), "YES");
	}

	public void test4() {
		RETester.eq(solve(new String[] {
			"XXXXXXX"
			,"X.....X"
			,"X.....X"
			,"X.....X"
			,"XXXXXXX"},
			new String[] {
			".X."
			,"XXX"
			,".X."}),
			"NO");
	}

	public void test5() {
		RETester.eq(solve(new String[] {
			".."
			,"X."
			,".X"},
			new String[] {
			".."
			,".X"
			,"X."}),
			"NO");
	}

	public void test6() {
		RETester.eq(solve(new String[] {
			"X.."
			,".XX"
			,".XX"},
			new String[] {
			".XX"
			,".XX"
			,"X.."}),
			"NO");
	}

// END CUT HERE
}

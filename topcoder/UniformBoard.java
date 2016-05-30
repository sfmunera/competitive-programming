
public class UniformBoard {
    public int getBoard(String[] board, int K) {
        int N = board.length;
        int max = 0;
        
        int cntApples = 0;
        int cntPears = 0;
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		if (board[i].charAt(j) == 'A')
        			++cntApples;
        		else if (board[i].charAt(j) == 'P')
        			++cntPears;
        
        
        for (int i = 0; i < N; ++i)
        	for (int j = 0; j < N; ++j)
        		for (int k = i; k < N; ++k)
        			for (int l = j; l < N; ++l) {
        				int A = 0;
        				int P = 0;
        				int size = (k - i + 1) * (l - j + 1);
        				int cnt = 0;
        				for (int a = i; a <= k; ++a)
        					for (int b = j; b <= l; ++b)
        						if (board[a].charAt(b) == 'A')
        		        			++A;
        		        		else if (board[a].charAt(b) == 'P')
        		        			++P;
        				
        				if (cntApples - A >= size - A - P) {
        					cnt += size - A - P;
        					A += size - A - P;
        					
        					if (cntApples - A >= P && N * N - cntApples - cntPears > 0) {
        						cnt += 2 * P;
        						A += P;
        					}
        				}
        				
        				if (A == size && cnt <= K)
        					max = Math.max(max, size);
        			}
        
        return max;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(UniformBoard.class, "test.*");
    }

	public void test0() {
		RETester.eq(getBoard(new String[] {
			"AP",
			".A"},
			0), 1);
	}

	public void test1() {
		RETester.eq(getBoard(new String[] {
			"AP",
			".A"},
			1), 2);
	}

	public void test2() {
		RETester.eq(getBoard(new String[] {
			"PPP",
			"APA",
			"A.P"},
			2), 3);
	}

	public void test3() {
		RETester.eq(getBoard(new String[] {
			"AAA",
			"PPP",
			"AAA"},
			10), 3);
	}

	public void test4() {
		RETester.eq(getBoard(new String[] {"."}, 1000), 0);
	}

	public void test5() {
		RETester.eq(getBoard(new String[] {
			"PPAAPA..AP",
			"PPA.APAP..",
			"..P.AA.PPP",
			"P.P..APAA.",
			"P.P..P.APA",
			"PPA..AP.AA",
			"APP..AAPAA",
			"P.P.AP...P",
			".P.A.PAPPA",
			"..PAPAP..P"},
			10), 15);
	}

// END CUT HERE
}

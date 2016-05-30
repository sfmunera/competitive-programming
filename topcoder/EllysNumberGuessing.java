
public class EllysNumberGuessing {
    public int getNumber(int[] guesses, int[] answers) {
        int first = guesses[0] - answers[0];
        int second = guesses[0] + answers[0];
        
        for (int i = 0; i < guesses.length; ++i) {
        	int f = guesses[i] - answers[i];
        	int s = guesses[i] + answers[i];
        	
        	if (first != f && first != s)
        		first = -1;
        	if (second != f && second != s)
        		second = -1;
        }        
        if ((first < 1 || first > 1e9) && (second < 1 || second > 1e9))
        	return -2;
        if ((first >= 1 && first <= 1e9) && (second >= 1 && second <= 1e9))
        	return -1;
        if (first >= 1 && first <= 1e9)
        	return first;
        return second;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllysNumberGuessing.class, "test.*");
    }

	public void test0() {
		RETester.eq(getNumber(new int[] {600, 594}, new int[] {6, 12}), 606);
	}

	public void test1() {
		RETester.eq(getNumber(new int[] {100, 50, 34, 40}, new int[] {58, 8, 8, 2}), 42);
	}

	public void test2() {
		RETester.eq(getNumber(new int[] {500000, 600000, 700000}, new int[] {120013, 220013, 79987}), -2);
	}

	public void test3() {
		RETester.eq(getNumber(new int[] {500000000}, new int[] {133742666}), -1);
	}

	public void test4() {
		RETester.eq(getNumber(new int[] {
			76938260, 523164588, 14196746, 296286419, 535893832,
			41243148, 364561227, 270003278, 472017422, 367932361,
			395758413, 301278456, 186276934, 316343129, 336557549,
			52536121, 98343562, 356769915, 89249181, 335191879},
			new int[] {
			466274085, 20047757, 529015599, 246925926, 7318513,
			501969197, 178651118, 273209067, 71194923, 175279984,
			147453932, 241933889, 356935411, 226869216, 206654796,
			490676224, 444868783, 186442430, 453963164, 208020466}),
			543212345);
	}

	public void test5() {
		RETester.eq(getNumber(new int[] {42}, new int[] {42}), 84);
	}

	public void test6() {
		RETester.eq(getNumber(new int[] {999900000}, new int[] {100001}), 999799999);
	}

// END CUT HERE
}

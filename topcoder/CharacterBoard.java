import java.util.*;

public class CharacterBoard {
    public int countGenerators(String[] fragment, int W, int i0, int j0) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(CharacterBoard.class, "test.*");
    }

	public void test0() {
		RETester.eq(countGenerators(new String[] {
			"dea",
			"abc"}
			,
			7, 1, 1), 1);
	}

	public void test1() {
		RETester.eq(countGenerators(new String[] {
			"xyxxy"}
			,
			6, 1, 0), 28);
	}

	public void test2() {
		RETester.eq(countGenerators(new String[] {
			"gogogo",
			"jijiji",
			"rarara"}
			,
			6, 0, 0), 0);
	}

	public void test3() {
		RETester.eq(countGenerators(new String[] {
			"abababacac",
			"aaacacacbb",
			"ccabababab"}
			,
			8827, 104, 6022), 829146844);
	}

// END CUT HERE
}

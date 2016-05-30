import java.util.*;

public class LeftRightDigitsGame {
    public String minNumber(String digits) {
        String res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(LeftRightDigitsGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(minNumber("565"), "556");
	}

	public void test1() {
		RETester.eq(minNumber("9876543210"), "1234567890");
	}

	public void test2() {
		RETester.eq(minNumber("8016352"), "1086352");
	}

// END CUT HERE
}

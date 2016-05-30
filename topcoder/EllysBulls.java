import java.util.*;

public class EllysBulls {
    public String getNumber(String[] guesses, int[] bulls) {
        int N = bulls.length;
        int K = guesses[0].length();
        
        int cnt = 0;
        for (int i = 1; i < (1 << K); ++i) {
        	boolean ok = true;
        	for (int j = 0; j < N; ++j) {
        		for (int k = 0; k < K; ++k) {
        			if ((i & (1 << (guesses[j].charAt(k) - '0'))) == 0)
        		}
        	}
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllysBulls.class, "test.*");
    }

	public void test0() {
		RETester.eq(getNumber(new String[] {"1234", "4321", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"}, new int[] {2, 1, 1, 0, 2, 0, 0, 0, 1, 0, 0}), "1337");
	}

	public void test1() {
		RETester.eq(getNumber(new String[] {"0000", "1111", "2222"}, new int[] {2, 2, 2}), "Liar");
	}

	public void test2() {
		RETester.eq(getNumber(new String[] {"666666", "666677", "777777", "999999"}, new int[] {2, 3, 1, 0}), "Ambiguity");
	}

	public void test3() {
		RETester.eq(getNumber(new String[] {"000", "987", "654", "321", "100", "010"}, new int[] {2, 1, 0, 0, 1, 1}), "007");
	}

	public void test4() {
		RETester.eq(getNumber(new String[] {
			"28", "92", "70", "30", "67", "63", "06", "65",
			"11", "06", "88", "48", "09", "65", "48", "08"},
			new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), "54");
	}

	public void test5() {
		RETester.eq(getNumber(new String[] {
			"0294884", "1711527", "2362216", "7666148", "7295642",
			"4166623", "1166638", "2767693", "8650248", "2486509",
			"6138934", "4018642", "6236742", "2961643", "8407361",
			"2097376", "6575410", "6071777", "3569948", "2606380"},
			new int[] {1, 0, 1, 3, 4, 4, 3, 2, 1, 1, 0, 4, 4, 3, 0, 0, 0, 0, 2, 1}), "4266642");
	}

// END CUT HERE
}

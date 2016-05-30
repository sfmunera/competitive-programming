import java.util.*;

public class TheSquareDivTwo {
    public String[] solve(String[] board) {
        String[] res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheSquareDivTwo.class, "test.*");
    }

	public void test0() {
		RETester.eq(solve(new String[] {
			"..",
			"C."}),
			new String[] {"..", ".C" });
	}

	public void test1() {
		RETester.eq(solve(new String[] {
			"CC",
			".C"}),
			new String[] {"C.", "CC" });
	}

	public void test2() {
		RETester.eq(solve(new String[] {
			".C..",
			"CC.C",
			"..C.",
			"CCCC"}),
			new String[] {"...C", ".C.C", ".C.C", "CCCC" });
	}

	public void test3() {
		RETester.eq(solve(new String[] {
			"...CCC",
			"...CCC",
			"...CCC",
			"CCC...",
			"CCC...",
			"CCC..."}),
			new String[] {"......", "......", "......", "CCCCCC", "CCCCCC", "CCCCCC" });
	}

	public void test4() {
		RETester.eq(solve(new String[] {
			".....C",
			"....CC",
			"...CCC",
			"..CCCC",
			".CCCCC",
			"CCCCCC"}),
			new String[] {".....C", "....CC", "...CCC", "..CCCC", ".CCCCC", "CCCCCC" });
	}

	public void test5() {
		RETester.eq(solve(new String[] {
			"C.C..C.C..C..C.",
			"CCC...C..CCC.C.",
			"......CC...CCCC",
			".C..CC.C.C.C.C.",
			"C....C.C......C",
			".....C..CCCCC.C",
			"CCC.......CCCCC",
			"..C.C..C.C...C.",
			"CCC....CCC.CC..",
			"CC.CCCC.CCCC...",
			".C..C.CC.C.CC.C",
			"C.CCCC..CC..C.C",
			".CCCC.CCCCCC...",
			"..C...C.CCC.CC.",
			"CCCC..CCC.C...."}),
			new String[] {"...............", "...............", "...............", "...............", "...............", ".........C..C..", ".........C.CC..", ".C....C.CCCCC.C", ".C.C.CC.CCCCCCC", "CCCC.CC.CCCCCCC", "CCCC.CCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC", "CCCCCCCCCCCCCCC" });
	}

// END CUT HERE
}

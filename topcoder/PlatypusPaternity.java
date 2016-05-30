
import java.util.*;

public class PlatypusPaternity {
    public int maxFamily(String[] fc, String[] mc, String[] sg) {
        int F = fc.length;
        int M = mc.length;
        int S = sg.length;
        int C = fc[0].length();
        int res = 0;
        
        for (int i = 0; i < F; ++i)
        	for (int j = 0; j < M; ++j)
        		for (int k = 0; k < S; ++k) {
        			int cnt = 0;
        			boolean valid = true;
        			for (int l = 0; l < C; ++l)
        				if (sg[k].charAt(l) == 'Y') {
        					if (fc[i].charAt(l) == 'Y' && 
            					mc[j].charAt(l) == 'Y')
        						++cnt;
        					else
        						valid = false;
        				}
        					
        			if (valid)
        				res = Math.max(res, cnt);
        		}
        			
        return res == 0 ? 0 : res + 2;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PlatypusPaternity.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxFamily(new String[] {"YYYY", "YYYY"}, new String[] {"NNYN", "YYYN"}, new String[] {"YYYN", "NNNY"}), 5);
	}

	public void test1() {
		RETester.eq(maxFamily(new String[] {"NNYYY"}, new String[] {"YYNNN"}, new String[] {"YYNNN", "NNYYY"}), 0);
	}

	public void test2() {
		RETester.eq(maxFamily(new String[] {"YYYYYYYYN"}, new String[] {"YYYYYYYYY"}, new String[] {
			"YNYNYNYNY",
			"NNNYNYNNN",
			"NYNNNNNYN"}),
			4);
	}

	public void test3() {
		RETester.eq(maxFamily(new String[] {"YY"}, new String[] {"YY"}, new String[] {"YN", "NY"}), 3);
	}

	public void test4() {
		RETester.eq(maxFamily(new String[] {
			"YYNNYYNNYYNN",
			"YNYNYNYNYNYN",
			"YYYNNNYYYNNN"},
			new String[] {
			"NYYNNYYNNYYN",
			"YYNYYYNYYYNY",
			"NNNNNNYYYYYY"},
			new String[] {
			"NYNNNYNNNNNN",
			"NNNNNNNNYNNN",
			"NNYNNNNNNNYN",
			"YNNNNNNYNNNN",
			"NNNNNNNNNYNY",
			"NNNYYNYNNNNN"}),
			4);
	}

// END CUT HERE
}

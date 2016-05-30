import java.util.*;

public class ShoutterDiv1 {
    public int count(String[] s1000, String[] s100, String[] s10, String[] s1, String[] t1000, String[] t100, String[] t10, String[] t1) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ShoutterDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(count(new String[] {"22", "2"}, new String[] {"00", "0"}, new String[] {"11", "1"}, new String[] {"21", "4"}, new String[] {"22", "2"}, new String[] {"00", "0"}, new String[] {"11", "1"}, new String[] {"43", "6"}), 2);
	}

	public void test1() {
		RETester.eq(count(new String[] {"00"}, new String[] {"00"}, new String[] {"00"}, new String[] {"13"}, new String[] {"00"}, new String[] {"00"}, new String[] {"00"}, new String[] {"24"}), -1);
	}

	public void test2() {
		RETester.eq(count(new String[] {"0000"}, new String[] {"0000"}, new String[] {"0000"}, new String[] {"1234"}, new String[] {"0000"}, new String[] {"0000"}, new String[] {"0000"}, new String[] {"2345"}), 6);
	}

	public void test3() {
		RETester.eq(count(new String[] {"0000000000"}, new String[] {"0000000000"}, new String[] {"0000000000"}, new String[] {"7626463146"}, new String[] {"0000000000"}, new String[] {"0000000000"}, new String[] {"0000000000"}, new String[] {"9927686479"}), 18);
	}

	public void test4() {
		RETester.eq(count(new String[] {"00000000000000000000000000000000000000000000000000"}, new String[] {"00000000000000000000000000000000000000000000000000"}, new String[] {"50353624751857130208544645495168271486083954769538"}, new String[] {"85748487990028258641117783760944852941545064635928"}, new String[] {"00000000000000000000000000000000000000000000000000"}, new String[] {"00000000000000000000000000000000000000000000000000"}, new String[] {"61465744851859252308555855596388482696094965779649"}, new String[] {"37620749792666153778227385275518278477865684777411"}), 333);
	}

// END CUT HERE
}

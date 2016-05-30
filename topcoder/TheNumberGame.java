
public class TheNumberGame {

	boolean equal(String A, String B) {
		for (int i = 0; i <= A.length(); ++i)
			for (int j = i + 1; j <= A.length(); ++j)
				if (A.substring(i, j).equals(B))
					return true;
		return false;
	}

    public String determineOutcome(int A, int B) {
    	
    	String strA = String.valueOf(A);
    	String strB = String.valueOf(B);
    	String revA = new StringBuffer(strA).reverse().toString();
    	String revB = new StringBuffer(strB).reverse().toString();
    	
    	boolean can = false;
    	if (equal(strA, strB) || equal(strA, revB) || equal(revA, strB) || equal(revA, revB))
    		can = true;
    	
        return can ? "Manao wins" : "Manao loses";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TheNumberGame.class, "test.*");
    }

	public void test0() {
		RETester.eq(determineOutcome(45, 4), "Manao wins");
	}

	public void test1() {
		RETester.eq(determineOutcome(45, 5), "Manao wins");
	}

	public void test2() {
		RETester.eq(determineOutcome(99, 123), "Manao loses");
	}

	public void test3() {
		RETester.eq(determineOutcome(2356236, 5666), "Manao loses");
	}

// END CUT HERE
}

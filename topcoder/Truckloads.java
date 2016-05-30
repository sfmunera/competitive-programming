
public class Truckloads {
    public int numTrucks(int numCrates, int loadSize) {
        if (numCrates <= loadSize) return 1;
        
        return numTrucks(numCrates / 2, loadSize) + numTrucks(numCrates - numCrates / 2, loadSize);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Truckloads.class, "test.*");
    }

	public void test0() {
		RETester.eq(numTrucks(14, 3), 6);
	}

	public void test1() {
		RETester.eq(numTrucks(15, 1), 15);
	}

	public void test2() {
		RETester.eq(numTrucks(1024, 5), 256);
	}

// END CUT HERE
}

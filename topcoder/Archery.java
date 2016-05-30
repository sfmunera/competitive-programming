
public class Archery {
    public double expectedPoints(int N, int[] ringPoints) {
        double A = Math.PI * (N + 1) * (N + 1);
        double sum = 0.0;
        for (int i = 0; i <= N; ++i)
        	sum += ringPoints[i] * Math.PI * ((i + 1) * (i + 1) - i * i);
        
        return sum / A;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Archery.class, "test.*");
    }

	public void test0() {
		RETester.eq(expectedPoints(1, new int[] {10, 0}), 2.5);
	}

	public void test1() {
		RETester.eq(expectedPoints(3, new int[] {1, 1, 1, 1}), 1.0);
	}

	public void test2() {
		RETester.eq(expectedPoints(4, new int[] {100, 0, 100, 0, 100}), 60.0);
	}

	public void test3() {
		RETester.eq(expectedPoints(9, new int[] {69, 50, 79, 16, 52, 71, 17, 96, 56, 32}), 51.96);
	}

// END CUT HERE
}

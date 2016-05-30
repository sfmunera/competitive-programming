import java.util.*;

public class ReturnToHome {
	public double goHome(int X, int Y, int D, int T) {
		double dist = Math.sqrt(X * X + Y * Y);
		
		double partial = Math.floor(dist / D) * T;
		double rem = Math.min(dist - Math.floor(dist / D) * D, T + D - (dist - Math.floor(dist / D) * D));
		
		System.out.println("dist = " + dist + ", partial = " + partial + ", rem = " + rem);
		
		return Math.min(dist, partial + rem);
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(ReturnToHome.class, "test.*");
	}

	public void test0() {
		RETester.eq(goHome(6, 8, 5, 3), 6.0);
	}

	public void test1() {
		RETester.eq(goHome(3, 4, 6, 3), 4.0);
	}

	public void test2() {
		RETester.eq(goHome(400, 300, 150, 10), 40.0);
	}

	public void test3() {
		RETester.eq(goHome(318, 445, 1200, 800), 546.9451526432975);
	}

	public void test4() {
		RETester.eq(goHome(6, 8, 3, 2), 7.0);
	}

	public void test5() {
		RETester.eq(goHome(10, 10, 1000, 5), 10.0);
	}

// END CUT HERE
}


public class Intersect {
	
	int[] intersect(int[] s1, int[] s2) {
		if (s1.length == 0 || s2.length == 0)
			return new int[]{};
		if (s2[0] > s1[1] || s2[0] > s1[1])
			return new int[]{};
		if (s1[0] >= s2[0] && s1[1] <= s2[1])
			return s1;
		if (s2[0] >= s1[0] && s2[1] <= s1[1])
			return s2;
		if (s2[0] > s1[0] && s2[0] < s1[1] && s2[1] > s1[1])
			return new int[]{s2[0], s1[1]};
		if (s2[1] > s1[0] && s2[1] < s1[1] && s2[0] < s1[0])
			return new int[]{s1[0], s2[1]};
		return new int[]{};
	}
	
	public int area(int[] x, int[] y) {
		int[] intx = new int[]{Math.min(x[0], x[1]), Math.max(x[0], x[1])};
		int[] inty = new int[]{Math.min(y[0], y[1]), Math.max(y[0], y[1])};
		
		for (int i = 2; i < x.length; i += 2) {
			int x0 = Math.min(x[i], x[i + 1]);
			int y0 = Math.min(y[i], y[i + 1]);
			int x1 = Math.max(x[i], x[i + 1]);
			int y1 = Math.max(y[i], y[i + 1]);
			
			intx = intersect(intx, new int[]{x0, x1});
			inty = intersect(inty, new int[]{y0, y1});
		}
		
		if (intx.length == 2 && inty.length == 2)
			return (intx[1] - intx[0]) * (inty[1] - inty[0]);
		return 0;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(Intersect.class, "test.*");
	}

	public void test0() {
		RETester.eq(area(new int[] {0,2,3,-4}, new int[] {17,1000,18,6}), 2);
	}

	public void test1() {
		RETester.eq(area(new int[] {10000,-10000}, new int[] {-10000,10000}), 400000000);
	}

	public void test2() {
		RETester.eq(area(new int[] {3,8,6,12,10,15}, new int[] {7,17,7,17,7,17}), 0);
	}

	public void test3() {
		RETester.eq(area(new int[] {0,0,0,0,0,0,0,0}, new int[] {5,5,5,5,5,5,5,5}), 0);
	}

	public void test4() {
		RETester.eq(area(new int[] {2,100,5,32,1000,-20,47,12}, new int[] {29,-1000,-800,-200,-900,300,-600,-650}), 1000);
	}

	public void test5() {
		RETester.eq(area(new int[] {1,7,12,3,16,8,3,12}	, new int[] {-90,-60,-70,3,-60,-90,-80,-100}), 0);
	}

// END CUT HERE
}


public class Segments {
    public String intersection(int[] s1, int[] s2) {
        int x0 = Math.min(s1[0], s1[2]);
        int y0 = Math.min(s1[1], s1[3]);
        int x1 = Math.max(s1[0], s1[2]);
        int y1 = Math.max(s1[1], s1[3]);
        
        int x2 = Math.min(s2[0], s2[2]);
        int y2 = Math.min(s2[1], s2[3]);
        int x3 = Math.max(s2[0], s2[2]);
        int y3 = Math.max(s2[1], s2[3]);
        
        int left = Math.max(x0, x2);
        int right = Math.min(x1, x3);
        int top = Math.max(y0, y2);
        int bottom = Math.min(y1, y3);
        
        if (top > bottom || left > right)
        	return "NO";
        if (top == bottom && left == right)
        	return "POINT";
        return "SEGMENT";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Segments.class, "test.*");
    }

	public void test0() {
		RETester.eq(intersection(new int[] {0, 0, 0, 1}	, new int[] {1, 0, 1, 1}), "NO");
	}

	public void test1() {
		RETester.eq(intersection(new int[] {0, 0, 0, 1}, new int[] {0, 1, 0, 2}), "POINT");
	}

	public void test2() {
		RETester.eq(intersection(new int[] {0, -1, 0, 1}, new int[] {-1, 0, 1, 0}), "POINT");
	}

	public void test3() {
		RETester.eq(intersection(new int[] {0, 0, 2, 0}, new int[] {1, 0, 10, 0}), "SEGMENT");
	}

	public void test4() {
		RETester.eq(intersection(new int[] {5, 5, 5, 5}, new int[] {6, 6, 6, 6}), "NO");
	}

	public void test5() {
		RETester.eq(intersection(new int[] {10, 0, -10, 0}, new int[] {5, 0, -5, 0}), "SEGMENT");
	}

// END CUT HERE
}

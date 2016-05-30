
public class BoxUnion {
	
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
	
	public int area(String[] rectangles) {
		int N = rectangles.length;
		int[] x0 = new int[N];
		int[] y0 = new int[N];
		int[] x1 = new int[N];
		int[] y1 = new int[N];
		
		for (int i = 0; i < N; ++i) {
			String[] parts = rectangles[i].split("[ ]");
			x0[i] = Integer.parseInt(parts[0]);
			y0[i] = Integer.parseInt(parts[1]);
			x1[i] = Integer.parseInt(parts[2]);
			y1[i] = Integer.parseInt(parts[3]);
		}
		
		if (N == 1)
			return (x1[0] - x0[0]) * (y1[0] - y0[0]);
		if (N == 2) {
			int A1 = (x1[0] - x0[0]) * (y1[0] - y0[0]);
			int A2 = (x1[1] - x0[1]) * (y1[1] - y0[1]);
			
			int[] intx = intersect(new int[]{x0[0], x1[0]}, new int[]{x0[1], x1[1]});
			int[] inty = intersect(new int[]{y0[0], y1[0]}, new int[]{y0[1], y1[1]});
			
			int A12 = 0;
			if (intx.length != 0 || inty.length != 0)
				A12 = (intx[1] - intx[0]) * (inty[1] - inty[0]);
			
			return A1 + A2 - A12;
		}
		if (N == 3) {
			int A1 = (x1[0] - x0[0]) * (y1[0] - y0[0]);
			int A2 = (x1[1] - x0[1]) * (y1[1] - y0[1]);
			int A3 = (x1[2] - x0[2]) * (y1[2] - y0[2]);
			
			int[] intx12 = intersect(new int[]{x0[0], x1[0]}, new int[]{x0[1], x1[1]});
			int[] inty12 = intersect(new int[]{y0[0], y1[0]}, new int[]{y0[1], y1[1]});
			
			int A12 = 0;
			if (intx12.length == 2 && inty12.length == 2)
				A12 = (intx12[1] - intx12[0]) * (inty12[1] - inty12[0]);
			
			int[] intx13 = intersect(new int[]{x0[0], x1[0]}, new int[]{x0[2], x1[2]});
			int[] inty13 = intersect(new int[]{y0[0], y1[0]}, new int[]{y0[2], y1[2]});
			
			int A13 = 0;
			if (intx13.length == 2 && inty13.length == 2)
				A13 = (intx13[1] - intx13[0]) * (inty13[1] - inty13[0]);
			
			int[] intx23 = intersect(new int[]{x0[1], x1[1]}, new int[]{x0[2], x1[2]});
			int[] inty23 = intersect(new int[]{y0[1], y1[1]}, new int[]{y0[2], y1[2]});
			
			int A23 = 0;
			if (intx23.length == 2 && inty23.length == 2)
				A23 = (intx23[1] - intx23[0]) * (inty23[1] - inty23[0]);
			
			int[] intx123 = intersect(intx12, new int[]{x0[2], x1[2]});
			int[] inty123 = intersect(inty12, new int[]{y0[2], y1[2]});
			
			int A123 = 0;
			if (intx123.length == 2 && inty123.length == 2)
				A123 = (intx123[1] - intx123[0]) * (inty123[1] - inty123[0]);
			
			return A1 + A2 + A3 - A12 - A13 - A23 + A123;
		}
		
		return 0;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(BoxUnion.class, "test.*");
	}

	public void test0() {
		RETester.eq(area(new String[] { "200 300 203 304" }), 12);
	}

	public void test1() {
		RETester.eq(area(new String[] {
			"0 0 10 10",
			"20 20 30 30" }),
			200);
	}

	public void test2() {
		RETester.eq(area(new String[] {
			"0 500 20000 501",
			"500 0 501 20000" }),
			39999);
	}

	public void test3() {
		RETester.eq(area(new String[] {
			"4 6 18 24",
			"7 2 12 19",
			"0 0 100 100" }),
			10000);
	}

	public void test4() {
		RETester.eq(area(new String[] {
			"1 3 5 6",
			"3 1 7 5",
			"4 4 9 7" }),
			35);
	}

	public void test5() {
		RETester.eq(area(new String[] {
			"0 0 20000 20000",
			"0 0 20000 20000",
			"0 0 20000 20000" }),
			400000000);
	}
	
	public void test6() {
		RETester.eq(area(new String[] {
			"2897 12378 7298 18473",
			"14873 234 19483 2534",
			"5098 2347 8592 12834" }),
			73065473);
	}

// END CUT HERE
}

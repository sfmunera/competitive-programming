
public class ParallelepipedUnion {
	
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
	
	public int getVolume(String[] p) {
		int[] x1 = new int[2];
		int[] y1 = new int[2];
		int[] z1 = new int[2];
		int[] x2 = new int[2];
		int[] y2 = new int[2];
		int[] z2 = new int[2];
		
		for (int i = 0; i < 2; ++i) {
			String[] parts = p[i].split("[ ]+");
			x1[i] = Integer.parseInt(parts[0]);
			y1[i] = Integer.parseInt(parts[1]);
			z1[i] = Integer.parseInt(parts[2]);
			x2[i] = Integer.parseInt(parts[3]);
			y2[i] = Integer.parseInt(parts[4]);
			z2[i] = Integer.parseInt(parts[5]);
		}
		
		int V1 = (x2[0] - x1[0]) * (y2[0] - y1[0]) * (z2[0] - z1[0]);
		int V2 = (x2[1] - x1[1]) * (y2[1] - y1[1]) * (z2[1] - z1[1]);
		
		int V12 = 0;
		int[] intx = intersect(new int[]{x1[0], x2[0]}, new int[]{x1[1], x2[1]});
		int[] inty = intersect(new int[]{y1[0], y2[0]}, new int[]{y1[1], y2[1]});
		int[] intz = intersect(new int[]{z1[0], z2[0]}, new int[]{z1[1], z2[1]});
		
		if (intx.length == 2 && inty.length == 2 && intz.length == 2)
			V12 = (intx[1] - intx[0]) * (inty[1] - inty[0]) * (intz[1] - intz[0]);
		
		return V1 + V2 - V12;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(ParallelepipedUnion.class, "test.*");
	}

	public void test0() {
		RETester.eq(getVolume(new String[] {"1 1 1 4 4 2", "3 2 1 5 3 3"}), 12);
	}

	public void test1() {
		RETester.eq(getVolume(new String[] {"1 1 1 2 2 2", "3 3 3 4 4 4"}), 2);
	}

	public void test2() {
		RETester.eq(getVolume(new String[] {"1 10 20 5 15 23", "2 12 22 3 14 23"}), 60);
	}

	public void test3() {
		RETester.eq(getVolume(new String[] {"28 31 21 67 60 81","60 1 21 67 50 81"}), 80460);
	}

	public void test4() {
		RETester.eq(getVolume(new String[] {"34 3 50 37 6 53","36 1 51 38 4 55"}), 49);
	}

// END CUT HERE
}

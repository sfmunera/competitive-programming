
public class Haar1D {
	
	int[] solve(int[] data, int L, int len) {
		if (L == 0) return data;
		
		int[] res = data.clone();
		int k = 0;
		for (int i = 0; i < len; i += 2)
			res[k++] = data[i] + data[i + 1];
		for (int i = 0; i < len; i += 2)
			res[k++] = data[i] - data[i + 1];
		return solve(res, L - 1, len / 2);
	}
	
    public int[] transform(int[] data, int L) {
        return solve(data, L, data.length);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Haar1D.class, "test.*");
    }

	public void test0() {
		RETester.eq(transform(new int[] {1, 2, 3, 5}, 1), new int[] {3, 8, -1, -2 });
	}

	public void test1() {
		RETester.eq(transform(new int[] {1, 2, 3, 5}, 2), new int[] {11, -5, -1, -2 });
	}

	public void test2() {
		RETester.eq(transform(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, 3), new int[] {20, 0, -4, 4, -1, -1, 1, 1 });
	}

	public void test3() {
		RETester.eq(transform(new int[] {94, 47, 46, 28, 39, 89, 75, 4, 28, 62, 69, 89, 34, 55, 81, 24}, 2), new int[] {215, 207, 248, 194, 67, 49, -68, -16, 47, 18, -50, 71, -34, -20, -21, 57 });
	}

// END CUT HERE
}

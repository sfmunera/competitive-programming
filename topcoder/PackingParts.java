
public class PackingParts {
    public int pack(int[] partSizes, int[] boxSizes) {
        int ans = 0;
        int j = partSizes.length - 1;
        for (int i = boxSizes.length - 1; i >= 0; --i) {
        	while (j >= 0 && partSizes[j] > boxSizes[i])
        		--j;
        	if (j >= 0)
        		++ans;
        	--j;
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PackingParts.class, "test.*");
    }

	public void test0() {
		RETester.eq(pack(new int[] {2,2,2}, new int[] {1,2,2,3}), 3);
	}

	public void test1() {
		RETester.eq(pack(new int[] {1,5}, new int[] {2,5}), 2);
	}

	public void test2() {
		RETester.eq(pack(new int[] {10,10,10,10}, new int[] {9,9,9,10,10,10}), 3);
	}

	public void test3() {
		RETester.eq(pack(new int[] {1,1,1,1}, new int[] {1,2,2,3,6,7}), 4);
	}

	public void test4() {
		RETester.eq(pack(new int[] {1,1,1,1}, new int[] {2,3,6}), 3);
	}

	public void test5() {
		RETester.eq(pack(new int[] {10,32,46,55,55,84,100}, new int[] {15,31,34,46,59,68,83,99}), 6);
	}

// END CUT HERE
}

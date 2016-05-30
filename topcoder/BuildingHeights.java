
import java.util.*;

public class BuildingHeights {
    public int minimum(int[] heights) {
    	int N = heights.length;
        Arrays.sort(heights);
        
        int[] f = new int[N];
        f[0] = heights[0];
        for (int i = 1; i < N; ++i)
        	f[i] = heights[i] + f[i - 1];
        
        int ans = 0;
        for (int m = 1; m <= N; ++m) {
        	int min = Integer.MAX_VALUE;
        	for (int i = m - 1; i < N; ++i)
        		min = Math.min(min, m * heights[i] - (f[i] - (i >= m ? f[i - m] : 0)));
        	ans ^= min;
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(BuildingHeights.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimum(new int[] {1, 5, 4, 3, 8}), 22);
	}

	public void test1() {
		RETester.eq(minimum(new int[] {1, 2, 3}), 2);
	}

	public void test2() {
		RETester.eq(minimum(new int[] {3, 4, 1, 6, 8, 1}), 21);
	}

	public void test3() {
		RETester.eq(minimum(new int[] {
			990, 20, 2359, 1667, 51, 2455, 1659, 1093, 2015, 205, 656, 752, 1760, 1594, 857,
			2033, 1868, 1932, 2408, 1518, 91, 2220, 1696, 1552, 933, 143, 1888, 1261, 2298, 1975,
			929, 2139, 1994, 2139, 158, 896, 2093, 1816, 841, 459, 2020, 1496, 63, 131, 589, 919,
			1015, 1308, 350, 922, 326, 1792, 641, 2021, 843, 425, 1015, 231, 1685, 2165, 1057,
			1465, 655, 550, 1103, 812, 297, 2048, 1479, 1137, 6, 2350, 1484, 1420, 1332, 925, 2338,
			1198, 2232, 1539, 2119, 57, 830, 1611, 929, 525, 888}),
			56068);
	}

// END CUT HERE
}

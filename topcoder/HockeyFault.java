
public class HockeyFault {
    public int numPlayers(int width, int height, int x, int y, int[] px, int[] py) {
        int ans = 0;
        
        int r = height / 2;
        int xc1 = x;
        int yc1 = y + r;
        int xc2 = x + width;
        int yc2 = y + r;
        
        for (int i = 0; i < px.length; ++i) {
        	if (px[i] >= x && px[i] <= x + width && py[i] >= y && py[i] <= y + height) {
        		++ans;
        		continue;
        	}
        	double d1 = Math.sqrt((px[i] - xc1) * (px[i] - xc1) + (py[i] - yc1) * (py[i] - yc1));
        	double d2 = Math.sqrt((px[i] - xc2) * (px[i] - xc2) + (py[i] - yc2) * (py[i] - yc2));
        	
        	if (d1 <= r || d2 <= r)
        		++ans;
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(HockeyFault.class, "test.*");
    }

	public void test0() {
		RETester.eq(numPlayers(20, 10, 5, 0, new int[] {15, 1, 1}, new int[] {5, 5, 1}), 2);
	}

	public void test1() {
		RETester.eq(numPlayers(20, 10, 0, 0, new int[] {-5, -4, -4, -3, -3, 0, 0, 20, 20, 23, 23, 24, 24, 25}, new int[] {5, 2, 8, 1, 9, 0, 10, 0, 10, 1, 9, 2, 8, 5}), 14);
	}

	public void test2() {
		RETester.eq(numPlayers(52, 84, -44, 66, new int[] {26, -33, -49, 40, -10, 47, 25, -16, -82, 7}, new int[] {118, 106, 128, 114, 101, 85, 142, 140, 126, 145}), 8);
	}

	public void test3() {
		RETester.eq(numPlayers(24, 100, -61, 71, new int[] {-63, -26, -9, -113, -124, -95, -89, -55}, new int[] {109, 164, 91, 80, 75, 140, 116, 113}), 6);
	}

// END CUT HERE
}

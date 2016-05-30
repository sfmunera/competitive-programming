import java.util.*;

public class Chocolate {
    public int minSplitNumber(int width, int height, int nTiles) {
        if (nTiles % width == 0 && nTiles / width == height)
        	return 0;
        
        if ((nTiles % width == 0 && height > nTiles / width) ||
        	(nTiles % height == 0 && width > nTiles / height))
        	return 1;
                
        for (int i = 1; i * i <= nTiles; ++i)
        	if (nTiles % i == 0) {
        		int j = nTiles / i;
        		if ((i < width && j < height) || (j < width && i < height))
        			return 2;
        	}
        
        return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Chocolate.class, "test.*");
    }

	public void test0() {
		RETester.eq(minSplitNumber(5, 4, 12), 1);
	}

	public void test1() {
		RETester.eq(minSplitNumber(12, 10, 120), 0);
	}

	public void test2() {
		RETester.eq(minSplitNumber(2, 2, 1), 2);
	}

	public void test3() {
		RETester.eq(minSplitNumber(17, 19, 111), -1);
	}

// END CUT HERE
}

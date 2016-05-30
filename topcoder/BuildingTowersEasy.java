package topcoder;

import java.util.*;

public class BuildingTowersEasy {
	
    public int maxHeight(int N, int[] x, int[] t) {
    	if (x.length == 0) {
    		return N - 1;
    	}
    	int ans = 0;
        for (int i = 0; i < x.length; ++i) {
        	int xp = i == 0 ? 0 : x[i - 1];
        	int tp = i == 0 ? 0 : t[i - 1];
        	
        	int l = xp;
        	int r = x[i];
        	int hl = tp;
        	int hr = t[i];
        	
        	if (x[i] - xp <= Math.abs(t[i] - tp)) {
        		
        	}
        	
        	while (l + 1 < r) {
        		++hl; ++hr;
        		++l; --r;
        	}
        	
        	int h = Math.min(hl, hr);
        	if (h < t[i]) {
        		t[i] = h;
        	}
        	ans = Math.max(ans, h);
        }
        
        System.out.println(Arrays.toString(t));
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(BuildingTowersEasy.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxHeight(10, new int[] {3,8}, new int[] {1,1}), 3);
	}

	public void test1() {
		RETester.eq(maxHeight(100000, new int[] {}, new int[] {}), 99999);
	}

	public void test2() {
		RETester.eq(maxHeight(2718, new int[] {1,30,400,1300,2500}, new int[] {100000,100000,100000,100000,100000}), 2717);
	}

	public void test3() {
		RETester.eq(maxHeight(20, new int[] {4,7,13,15,18}, new int[] {3,8,1,17,16}), 8);
	}

	public void test4() {
		RETester.eq(maxHeight(447, new int[] {32,35,55,60,61,88,91,97,128,151,181,186,192,196,198,237,259,268,291,314,341,367,389,390,391,428,435}, new int[] {81,221,172,641,25,953,330,141,123,440,692,394,200,649,78,726,50,810,501,4,216,407,2,172,0,29,14}), 120);
	}

	public void test5() {
		RETester.eq(maxHeight(97638, new int[] {
			8,1749,4550,5388,6752,7089,9737,14891,16671,16821,17691,19753,24589,
			25348,30114,32213,34376,36467,37699,41490,44784,44893,57316,58275,58567,
			61122,61489,63195,64776,65905,68788,69908,72853,78152,78784,82779,84488,
			86277,88611,92793,93214,97583},
			new int[] {
			16610,6,497,14,42892,31,79,1203,518,31147,597,7846,1396,8309,12,14,1148,
			433,23693,13,1939,244,19,46,27,611,412,10,27023,19141,34,15667,588,10,229,
			83,390,14,38441,16021,4,39386}),
			6343);
	}

// END CUT HERE
}

package topcoder;

import java.util.*;

public class SurveillanceSystem {
    public String getContainerInfo(String containers, int[] reports, int L) {
    	int N = containers.length();
        boolean[] watched = new boolean[N];
        boolean[] possible = new boolean[N];
        
        int[] reportCnt = new int[L + 1];
        for (int i = 0; i < reports.length; ++i)
        	++reportCnt[reports[i]];
                
        for (int i = 0; i < reports.length; ++i) {
        	int mask = (1 << N) - 1;
        	
        	int cntIntervals = 0;
        	for (int j = 0; j <= N - L; ++j) {
        		int cnt = 0;
        		for (int k = 0; k < L; ++k)
        			if (containers.charAt(j + k) == 'X')
        				++cnt;
        		if (cnt == reports[i])
        			++cntIntervals;
        	}
        	
        	int maskTmp = 0;
        	for (int j = 0; j <= N - L; ++j) {
        		int cnt = 0;
        		for (int k = 0; k < L; ++k)
        			if (containers.charAt(j + k) == 'X')
        				++cnt;
        		if (cnt == reports[i]) {
        			
        			int mask2 = 0;
        			if (reportCnt[reports[i]] >= cntIntervals)
        				mask2 = maskTmp;
        			for (int k = 0; k < L; ++k) {
        				mask2 |= (1 << (j + k));
        				possible[j + k] = true;
        			}
        			maskTmp |= mask2;
        			mask &= mask2;
        			//System.out.println(reports[i] + " " + Integer.toBinaryString(mask));
        		}
        	}
        	
        	for (int j = 0; j < N; ++j)
        		if ((mask & (1 << j)) > 0)
        			watched[j] = true;
        	//System.out.println(Arrays.toString(watched));
        }
        
        String ans = "";
        for (int i = 0; i < N; ++i)
        	if (watched[i])
        		ans += "+";
        	else if (possible[i])
        		ans += "?";
        	else
        		ans += "-";
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SurveillanceSystem.class, "test.*");
    }

	public void test0() {
		RETester.eq(getContainerInfo("-X--XX", new int[] {1, 2}, 3), "??++++");
	}

	public void test1() {
		RETester.eq(getContainerInfo("-XXXXX-", new int[] {2}, 3), "???-???");
	}

	public void test2() {
		RETester.eq(getContainerInfo("------X-XX-", new int[] {3, 0, 2, 0}, 5), "++++++++++?");
	}

	public void test3() {
		RETester.eq(getContainerInfo("-XXXXX---X--", new int[] {2, 1, 0, 1}, 3), "???-??++++??");
	}

	public void test4() {
		RETester.eq(getContainerInfo("-XX--X-XX-X-X--X---XX-X---XXXX-----X", new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 7), "???++++?++++++++++++++++++++??????--");
	}

// END CUT HERE
}

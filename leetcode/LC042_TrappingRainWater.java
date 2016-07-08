package leetcode;

import java.util.*;

public class LC042_TrappingRainWater {
    public int trap(int[] A) {
        int water = 0;
        
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for (int i = 0; i < A.length; ++i) {
            if (i == 0 || (i > 0 && A[i] > A[i - 1])) {
                int j = i;
                while (j < A.length && A[j] == A[i])
                    ++j;
                if (j >= A.length || A[j] < A[i]) {
                    peaks.add(i);
                    if (j < A.length && j - 1 > i) {
                        peaks.add(j - 1);
                    }
                }
                i = j - 1;
            }
        }

        for (int i = 0; i < peaks.size() - 1; ++i) {
            int next = i + 1;
            for (int j = i + 1; j < peaks.size(); ++j) {
                if (A[peaks.get(j)] > A[peaks.get(next)]) {
                    next = j;
                }
                if (A[peaks.get(next)] >= A[peaks.get(i)])
                	break;
            }

            int height = Math.min(A[peaks.get(i)], A[peaks.get(next)]);
            for (int j = peaks.get(i) + 1; j < peaks.get(next); ++j)
                if (height > A[j])
                    water += height - A[j];
            i = next - 1;
        }
        
        return water;
    }
}

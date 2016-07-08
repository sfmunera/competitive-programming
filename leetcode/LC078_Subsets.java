package leetcode;

import java.util.*;

public class LC078_Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
        int N = S.length;
        Arrays.sort(S);
        for (int mask = 0; mask < (1 << N); ++mask) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int i = 0; i < N; ++i) {
                if ((mask & (1 << i)) > 0) {
                    subset.add(S[i]);
                }
            }
            
            subsets.add(subset);
        }
        
        return subsets;
    }
}

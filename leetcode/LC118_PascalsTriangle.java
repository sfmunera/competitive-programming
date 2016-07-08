package leetcode;

import java.util.*;

public class LC118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        
        if (numRows > 0) {
            pascal.add(new ArrayList<Integer>());
            pascal.get(0).add(1);
        }
        
        for (int i = 1; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            
            if (i > 1) {
                List<Integer> prev = pascal.get(i - 1);
                for (int j = 1; j < i; ++j) {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            
            row.add(1);
            pascal.add(row);
        }
        return pascal;
    }
}

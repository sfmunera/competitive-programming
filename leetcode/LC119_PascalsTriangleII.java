package leetcode;

import java.util.*;

public class LC119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowPrev = new ArrayList<>();
        rowPrev.add(1);
        if (rowIndex == 0) {
            return rowPrev;
        }
        
        List<Integer> rowCur = new ArrayList<>();
        for (int i = 1; i <= rowIndex; ++i) {
            rowCur = new ArrayList<>();
            rowCur.add(1);
            for (int j = 1; j < i; ++j) {
                rowCur.add(rowPrev.get(j - 1) + rowPrev.get(j));
            }
            rowCur.add(1);
            rowPrev = new ArrayList<>(rowCur);
        }
        return rowCur;
    }
}
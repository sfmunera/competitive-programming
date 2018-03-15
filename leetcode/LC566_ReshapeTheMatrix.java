package leetcode;

public class LC566_ReshapeTheMatrix {
    
    // Time: O(R * C), Space: O(1) [not including input and output data structures]
    public int[][] matrixReshape(int[][] nums, int newRows, int newCols) {
        int originalRows = nums.length;
        int originalCols = nums[0].length;
        if (originalRows * originalCols != newRows * newCols) {
            return nums;
        }
        int[][] reshaped = new int[newRows][newCols];
        int index = 0;
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                reshaped[i][j] = nums[index / originalCols][index % originalCols];
                index++;
            }
        }
        return reshaped;
    }

}

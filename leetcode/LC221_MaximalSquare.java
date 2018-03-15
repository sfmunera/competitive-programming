
public class LC221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] ones = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) for (int j = 1; j <= cols; j++) {
        	ones[i][j] = matrix[i - 1][j - 1] - '0';
        }
        for (int i = 1; i <= rows; i++) for (int j = 1; j <= cols; j++) {
        	ones[i][j] += ones[i - 1][j] + ones[i][j - 1] - ones[i - 1][j - 1];
        }
        
        int ans = 0;
        for (int i = 1; i <= rows; i++) for (int j = 1; j <= cols; j++) {
        	for (int len = 1; len <= Math.min(i, j); len++) {
        		int area = ones[i][j] - ones[i - len][j] - ones[i][j - len] + ones[i - len][j - len];
        		if (area == len * len) {
        			ans = Math.max(ans, area);
        		}
        	}
        }
        return ans;
    }
}

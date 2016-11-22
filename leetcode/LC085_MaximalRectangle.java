package leetcode;

public class LC085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] ones = precomputeSum(matrix);
		int max = 0;
		for (int r1 = 0; r1 < rows; r1++) for (int c1 = 0; c1 < cols; c1++) {
			int r2 = r1;
			while (r2 < rows && matrix[r2][c1] == '1') {
				int lo = c1;
				int hi = cols - 1;
				while (lo <= hi) {
					int c2 = (lo + hi) / 2;
					int sum = getSum(ones, r1, c1, r2, c2);
					int area = (r2 - r1 + 1) * (c2 - c1 + 1);
					if (sum == area) {
						max = Math.max(max, area);
						lo = c2 + 1;
					} else if (sum < area) {
						hi = c2 - 1;
					} else {
						lo = c2 + 1;
					}
				}
				r2++;
			}
		}
		return max;
	}

	private int getSum(int[][] ones, int r1, int c1, int r2, int c2) {
		int sum = ones[r2][c2];
		if (r1 > 0) sum -= ones[r1 - 1][c2];
		if (c1 > 0) sum -= ones[r2][c1 - 1];
		if (r1 > 0 && c1 > 0) sum += ones[r1 - 1][c1 - 1];
		return sum;
	}


	private int[][] precomputeSum(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] ones = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ones[r][c] = matrix[r][c] - '0';
				if (r > 0) ones[r][c] += ones[r - 1][c];
				if (c > 0) ones[r][c] += ones[r][c - 1];
				if (r > 0 && c > 0) ones[r][c] -= ones[r - 1][c - 1];
			}
		}
		return ones;
	}
}

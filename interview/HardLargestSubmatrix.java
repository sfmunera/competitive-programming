package interview;

public class HardLargestSubmatrix {
	public static void main(String[] args) {
		int[][] matrix = {{  1,   2,   3,  -5,  -7,   9},
						  {  0,  10,  -4,   9,  -6,   1},
						  {  1,   2,   3,   4,   5,   6},
						  { -1,  -1,  -2,  -2,  -3,  -3},
						  { -3,   4,   5,  -7,   8,   9},
						  { -1,   2,  10,  20,  30,   0},
						  { -5,   0, -10, -40,  50,   5}};
		
		int R = matrix.length;
		int C = matrix[0].length;
		
		int[][] dp = new int[R][C];
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j) {
				dp[i][j] = matrix[i][j];
				if (i > 0)
					dp[i][j] += dp[i - 1][j];
				if (j > 0)
					dp[i][j] += dp[i][j - 1];
				if (i > 0 && j > 0)
					dp[i][j] -= dp[i - 1][j - 1];
			}
			
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				for (int k = i; k < R; ++k)
					for (int l = j; l < C; ++l) {
						int sum = dp[k][l];
						if (i > 0)
							sum -= dp[i - 1][l];
						if (j > 0)
							sum -= dp[k][j - 1];
						if (i > 0 && j > 0)
							sum += dp[i - 1][j - 1];
						max = Math.max(max, sum);
					}
		System.out.println(max);
	}
}

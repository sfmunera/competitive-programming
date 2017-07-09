public class IntersectionsEfficient {
	
	static final int UNIVERSE_SIZE = 100;
	static final int A_SIZE = 90;
	static final int B_SIZE = 80;
	static final int C_SIZE = 70;
	
	static final int INF = (int)1e9;
	static Integer[][][][] dp;
	
	static boolean isTaken(int mask, int bit) {
		return (mask & (1 << bit)) != 0;
	}
	
	static int solve(int index, int leftA, int leftB, int leftC) {
		if (leftA < 0 || leftB < 0 || leftC < 0) {
			return INF;
		}
		if (index == UNIVERSE_SIZE) {
			if (leftA == 0 && leftB == 0 && leftC == 0) {
				return 0;
			} else {
				return INF;
			}
		}
		if (dp[index][leftA][leftB][leftC] != null) {
			return dp[index][leftA][leftB][leftC];
		}
		int ans = INF;
		for (int mask = 0; mask < (1 << 3); mask++) {
			int nextLeftA = leftA - (isTaken(mask, 0) ? 1 : 0);
			int nextLeftB = leftB - (isTaken(mask, 1) ? 1 : 0);
			int nextLeftC = leftC - (isTaken(mask, 2) ? 1 : 0);
			boolean allTaken = Integer.bitCount(mask) == 3;
			ans = Math.min(ans, (allTaken ? 1 : 0) + solve(index + 1, nextLeftA, nextLeftB, nextLeftC));
		}
		return dp[index][leftA][leftB][leftC] = ans;
	}
	
	public static void main(String[] args) {
		dp = new Integer[UNIVERSE_SIZE + 1][A_SIZE + 1][B_SIZE + 1][C_SIZE + 1];
		int min = solve(0, A_SIZE, B_SIZE, C_SIZE);
		System.out.println("min = " + min);
	}
}

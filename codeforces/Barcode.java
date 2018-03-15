import java.util.*;

public class Barcode {
	
	static int[] columnCount;
	static int n, m, x, y;
	static Integer[][][] dp;
	
	static final int INF = (int) 1e9;
 	
	static int solve(int index, int currentWidth, boolean previousWhite) {
		if (index == m) {
			return x <= currentWidth && currentWidth <= y ? 0 : INF;
		}
		if (dp[index][currentWidth][previousWhite ? 1 : 0] != null) {
			return dp[index][currentWidth][previousWhite ? 1 : 0];
		}
		
		// try painting all column with white
		int ans1 = INF;
		int newWidth = index == 0 ? 1 : (previousWhite ? currentWidth + 1 : 1);
		if ((index == 0 || previousWhite || currentWidth >= x) && newWidth <= y) {
			ans1 = (n - columnCount[index]) + solve(index + 1, newWidth, true);
		}
		
		// try painting all column with black
		int ans2 = INF;
		newWidth = index == 0 ? 1 : (previousWhite ? 1 : currentWidth + 1);
		if ((index == 0 || !previousWhite || currentWidth >= x) && newWidth <= y) {
			ans2 = columnCount[index] + solve(index + 1, newWidth, false);
		}
		
		return dp[index][currentWidth][previousWhite ? 1 : 0] = Math.min(ans1, ans2);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		x = in.nextInt();
		y = in.nextInt();
		
		columnCount = new int[m];
		dp = new Integer[m + 1][m + 1][2];
		for (int i = 0; i < n; i++) {
			char[] row = in.next().toCharArray();
			for (int j = 0; j < m; j++) {
				columnCount[j] += row[j] == '.' ? 1 : 0;
			}
		}
		
		System.out.println(solve(0, 0, true));
		
		in.close();
		System.exit(0);
	}
}

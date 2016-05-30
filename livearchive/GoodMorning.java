package livearchive;

import java.util.*;
import java.io.*;

public class GoodMorning {
	
	static boolean[][] preprocessReachability() {
		int[][] numbers = 
			{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{-1, 0, -1},
			};
		boolean[][] canReach = new boolean[10][10];
		for (int i = 0; i < numbers.length; ++i) for (int j = 0; j < numbers[0].length; ++j)
			for (int k = i; k < numbers.length; ++k) for (int l = j; l < numbers[0].length; ++l) {
				if (numbers[i][j] < 0 || numbers[k][l] < 0) continue;
				canReach[numbers[i][j]][numbers[k][l]] = true;
			}
								
		return canReach;
	}
	
	static boolean can(int n, boolean[][] canReach) {
		if (n < 0) return false;
		
		Stack<Integer> digits = new Stack<Integer>();
		while (n > 0) {
			digits.push(n % 10);
			n /= 10;
		}
		
		int prev = digits.pop();
		while (!digits.isEmpty()) {
			int cur = digits.pop();
			if (!canReach[prev][cur])
				return false;
			prev = cur;
		}
		return true;
	}
	
	static int solve(int k, boolean[][] canReach) {
		int ans = 0;
		for (int i = 0; ; ++i) {
			if (can(k + i, canReach)) {
				ans = k + i;
				break;
			}
			if (can(k - i, canReach)) {
				ans = k - i;
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int k = in.nextInt();
			System.out.println(solve(k, preprocessReachability()));
		}
		
		in.close();
		System.exit(0);
	}
}

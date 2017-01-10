package codeforces;

import java.util.*;

public class CoatOfAnticubism {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] lengths = new int[n];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			lengths[i] = in.nextInt();
			max = Math.max(max, lengths[i]);
			sum += lengths[i];
		}
		int ans = max - (sum - max) + 1;
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}

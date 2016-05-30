package codeforces;

import java.util.*;

public class SettlersTraining {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] ranks = new int[k];
		
		for (int i = 0; i < n; ++i) {
			int rank = in.nextInt() - 1;
			++ranks[rank];
		}
		
		int coins = 0;
		while (ranks[k - 1] < n) {
			for (int i = k - 2; i >= 0; --i) {
				if (ranks[i] > 0) {
					--ranks[i];
					++ranks[i + 1];
				}
			}
			
			++coins;
		}
		
		System.out.println(coins);
		
		in.close();
		System.exit(0);
	}
}

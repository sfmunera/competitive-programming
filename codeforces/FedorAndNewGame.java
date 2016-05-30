package codeforces;

import java.util.*;

public class FedorAndNewGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		int[] others = new int[m];
		for (int i = 0; i < m; ++i) {
			others[i] = in.nextInt();
		}
		int fedor = in.nextInt();
		
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			ans += (Integer.bitCount(others[i] ^ fedor) <= k) ? 1 : 0;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}

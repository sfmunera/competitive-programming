package codeforces;

import java.util.*;
import java.io.*;

public class MoreCowbell {
	
	static boolean can(int[] cowbells, int s, int k) {
		
		int n = 0;
		for (n = cowbells.length - 1; n >= 0 && (n + 1) / 2 < k; --n, --k) {
			if (cowbells[n] > s) return false;
		}
		
		int l = 0;
		int r = n;
		while (l <= r) {
			if (l != r) {
				if (cowbells[l] + cowbells[r] > s) return false;
			} else {
				if (cowbells[l] > s) return false;
			}
			++l;
			--r;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int[] cowbells = new int[n];
		
		stk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; ++i) {
			cowbells[i] = Integer.parseInt(stk.nextToken());
		}
		
		int low = 0;
		int high = (int) 1e9;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (can(cowbells, mid, k)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}

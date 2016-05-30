package codeforces;

import java.util.*;
import java.io.*;

public class TheFibonacciSegment {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long[] A = new long[n];
		
		for (int i = 0; i < n; ++i)
			A[i] = in.nextLong();
		
		int ans = 0;
		int l = 0;
		for (int r = 2; r < n; ++r)
			if (A[r] != A[r - 1] + A[r - 2]) {
				ans = Math.max(ans, r - l);
				l = r - 1;
			}
		ans = Math.max(ans, n - l);
		
		System.out.println(ans);
		in.close();
		System.exit(0);
	}
}

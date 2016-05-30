package codeforces;

import java.util.*;

public class Trace {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] r = new int[n];
		
		for (int i = 0; i < n; ++i)
			r[i] = in.nextInt();
		Arrays.sort(r);
		
		int area = 0;
		int sign = 1;
		for (int i = n - 1; i >= 0; --i) {
			area += sign * r[i] * r[i];
			sign *= -1;
		}
		System.out.format("%.6f\n", Math.PI * area);
		
		in.close();
		System.exit(0);
	}
}

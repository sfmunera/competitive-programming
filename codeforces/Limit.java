package codeforces;

import java.util.*;

public class Limit {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] num = new int[n + 1];
		int[] den = new int[m + 1];
		
		int degreeNum = -1;
		int degreeDen = -1;
		for (int i = 0; i <= n; ++i) {
			num[n - i] = in.nextInt();
			if (degreeNum < 0 && num[n - i] != 0) {
				degreeNum = n - i;
			}
		}
		
		for (int i = 0; i <= m; ++i) {
			den[m - i] = in.nextInt();
			if (degreeDen < 0 && den[m - i] != 0) {
				degreeDen = m - i;
			}
		}
		assert degreeNum >= 0;
		assert degreeDen >= 0;
		
		int sign = num[degreeNum] * den[degreeDen] < 0 ? -1 : 1;
		if (degreeNum == degreeDen) {
			int g = gcd(Math.abs(num[degreeNum]), Math.abs(den[degreeDen]));			
			System.out.println((sign == -1 ? "-" : "") + (Math.abs(num[degreeNum]) / g) + "/" + (Math.abs(den[degreeDen]) / g));
		} else if (degreeNum > degreeDen) {
			System.out.println((sign == -1 ? "-" : "") + "Infinity");
		} else {
			System.out.println("0/1");
		}
		
		in.close();
		System.exit(0);
	}
}

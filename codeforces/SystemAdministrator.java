package codeforces;

import java.util.Scanner;


public class SystemAdministrator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] x = new int[3];
		int[] y = new int[3];

		for (int i = 0; i < n; ++i) {
			int c = in.nextInt();
			int xi = in.nextInt();
			int yi = in.nextInt();
			x[c] += xi;
			y[c] += yi;
		}
		
		for (int i = 1; i < 3; ++i) {
			if (x[i] >= y[i])
				System.out.println("LIVE");
			else
				System.out.println("DEAD");
		}
		
		in.close();
		System.exit(0);
	}
}

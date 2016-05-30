package codeforces;

import java.util.*;

public class MagicWizardryAndWonders {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int d = in.nextInt();
		int l = in.nextInt();
		
		int r = (n + 1) / 2;
		int s = n / 2;
		
		assert r + s == n;
		assert r >= s;
		
		if (d < r - s * l || d > r * l - s) {
			System.out.println(-1);
		} else {
			// construct set of numbers that gives the min value:
			// R = {1, 1, ...}
			// S = {l, l, ...}
			// and increase value in R until d is reached
			// if d is not reached, decrease values in S
			int[] R = new int[r];
			int[] S = new int[s];
			
			Arrays.fill(R, 1);
			Arrays.fill(S, l);
			
			int value = r - s * l;
			int ind = 0;
			while (ind < r && value < d) {
				++R[ind];
				if (R[ind] == l) {
					++ind;
				}
				++value;
			}
			
			ind = 0;
			while (ind < s && value < d) {
				--S[ind];
				if (S[ind] == 1) {
					++ind;
				}
				++value;
			}
			assert value == d;
			
			boolean first = true;
			for (int i = 0; i < s; ++i) {
				if (first) first = false;
				else System.out.print(" ");
				
				System.out.print(R[i] + " " + S[i]);
			}
			
			if (r > s) {
				if (first) first = false;
				else System.out.print(" ");
				System.out.print(R[r - 1]);
			}
		}
				
		in.close();
		System.exit(0);
	}
}

package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1611 (10670 - Work Reduction) */
/* SUBMISSION: 08897606 */
/* SUBMISSION TIME: 2011-05-28 20:55:13 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10670_WorkReduction {
	
	static class Agency implements Comparable<Agency> {
		String name;
		int cost;
		
		public Agency(String n, int c) {
			this.name = n;
			this.cost = c;
		}
		
		public int compareTo(Agency a) {
			if (this.cost != a.cost)
				return this.cost - a.cost;
			return this.name.compareTo(a.name);
		}
		
		public String toString() {
			return this.name + " " + this.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.nextLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.nextLine().split("[ ]");
			int N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			int L = Integer.parseInt(parts[2]);
			
			Agency[] agencies = new Agency[L];
			for (int i = 0; i < L; ++i) {
				parts = in.nextLine().split("[:,]");
				String name = parts[0];
				int A = Integer.parseInt(parts[1]);
				int B = Integer.parseInt(parts[2]);
				int tmp = N;
				int cost = 0;
				
				while (tmp / 2 >= M) {
					int r = tmp % 2;
					tmp /= 2;
					cost += Math.min(B, A * (tmp + r));
				}
				cost += A * (tmp - M);
				agencies[i] = new Agency(name, cost);
			}
			Arrays.sort(agencies);
			
			System.out.println("Case " + t);
			for (int i = 0; i < L; ++i)
				System.out.println(agencies[i]);
		}
	}
}
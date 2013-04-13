package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 382 (441 - Lotto) */
/* SUBMISSION: 09046538 */
/* SUBMISSION TIME: 2011-07-13 21:11:44 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00441_Lotto {
	
	static class Subset implements Comparable<Subset> {
		int[] set;
		int n;
		
		public Subset(int[] v) {
			this.set = v;
			this.n = v.length;
		}
		
		public int compareTo(Subset s) {
			for (int i = 0; i < this.n; ++i)
				if (this.set[i] != s.set[i])
					return this.set[i] - s.set[i];
			return 0;
		}
		
		public String toString() {
			String res = "";
			for (int i = 0; i < this.n; ++i) {
				if (i > 0)
					res += " ";
				res += this.set[i];
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean first = true;
		while (true) {
			int k = in.nextInt();
			if (k == 0)
				break;
			int[] set = new int[k];
			List<Subset> subsets = new ArrayList<Subset>();
			
			for (int i = 0; i < k; ++i)
				set[i] = in.nextInt();
			
			if (first)
				first = false;
			else
				System.out.println();
			
			for (int i = 0; i < (1 << k); ++i) {
				if (Integer.bitCount(i) == 6) {
					int[] sub = new int[6];
					int ind = 0;
					for (int j = 0; j < k; ++j)
						if ((i & (1 << j)) != 0)
							sub[ind++] = set[j];
					subsets.add(new Subset(sub));
				}
			}
			Collections.sort(subsets);
			for (Subset s : subsets)
				System.out.println(s);
		}
	}
}
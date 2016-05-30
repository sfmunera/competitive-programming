package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3977 (12532 - Interval Product) */
/* SUBMISSION: 10875024 */
/* SUBMISSION TIME: 2012-11-12 14:12:58 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12532_IntervalProduct {
	
	static void add(int[] t, int k, int v) {
		for (; k < t.length; k += k & -k)
			t[k] += v;
	}
	
	static int rsq(int[] t, int b) {
		int sum = 0;
		for (; b > 0; b -= b & -b)
			sum += t[b];
		return sum;
	}
	
	static int rsq(int[] t, int a, int b) {
		return rsq(t, b) - rsq(t, a - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int K = Integer.parseInt(parts[1]);
			
			int[] seq = new int[N];
			int[] treeZero = new int[N + 1];
			int[] treeNegative = new int[N + 1];

			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < N; ++i) {
				seq[i] = Integer.parseInt(parts[i]);
				if (seq[i] == 0)
					add(treeZero, i + 1, 1);
				if (seq[i] < 0)
					add(treeNegative, i + 1, 1);
			}
			
			for (int i = 0; i < K; ++i) {
				parts = in.readLine().split("[ ]+");
				if (parts[0].charAt(0) == 'C') {
					int k = Integer.parseInt(parts[1]);
					int V = Integer.parseInt(parts[2]);
					
					if (V == 0) {
						if (seq[k - 1] != 0)
							add(treeZero, k, 1);
						if (seq[k - 1] < 0)
							add(treeNegative, k, -1);
					} else if (V < 0) {
						if (seq[k - 1] >= 0)
							add(treeNegative, k, 1);
						if (seq[k - 1] == 0)
							add(treeZero, k, -1);
					} else {
						if (seq[k - 1] == 0)
							add(treeZero, k, -1);
						else if (seq[k - 1] < 0)
							add(treeNegative, k, -1);
					}
					seq[k - 1] = V;
				} else {
					int ind1 = Integer.parseInt(parts[1]);
					int ind2 = Integer.parseInt(parts[2]);
					
					if (rsq(treeZero, ind1, ind2) > 0)
						sb.append("0");
					else {
						int sum = rsq(treeNegative, ind1, ind2);
						if (sum % 2 == 0)
							sb.append("+");
						else
							sb.append("-");
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
package bapc;

import java.util.*;

public class BAPC13B_Bribe {
	
	static int[] b, p;
	static int n, c, m;
	
	static double go(int idx, int mask, int rem) {
		if (rem < 0) return 0.0;
		if (Integer.bitCount(mask) == c) return 1.0;
		if (idx < 0) return 0.0;
		
		double ans = 0.0;
		ans = Math.max(ans, p[idx] / 100.0 * go(idx - 1, mask | (1 << idx), rem - b[idx])); // success and change
		ans = Math.max(ans, p[idx] / 100.0 * go(idx,     mask | (1 << idx), rem - b[idx])); // success and stay
		//ans = Math.max(ans, go(idx - 1, mask, rem - b[idx])); // fail
		ans = Math.max(ans, go(idx - 1, mask, rem)); // just skip
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			n = in.nextInt();
			c = in.nextInt();
			m = in.nextInt();
			
			b = new int[n];
			p = new int[n];
			for (int i = 0; i < n; ++i) {
				b[i] = in.nextInt();
				p[i] = in.nextInt();
			}
			
			double ans = go(n - 1, 0, m);
			
			System.out.printf("%.6f\n", ans);
		}
		
		in.close();
		System.exit(0);
	}
}
